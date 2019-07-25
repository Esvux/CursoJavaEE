package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.dao.VoteDAO;
import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.dao.VotingTableDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.model.Vote;
import com.academik.minitse.model.Voter;
import com.academik.minitse.model.VotingTable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voteSubmitBean")
@RequestScoped
public class VoteSubmitBean {
    
    @Inject
    PoliticalPartyDAO daoPoliticalParty;
    
    @Inject
    VoteDAO daoVote;

    @Inject
    VoterDAO daoVoter;

    @Inject
    VotingTableDAO daoTable;
    
    @NotNull
    private String voterDPI;
    
    @NotNull
    private Long selectedVoteOption;
    
    private List<PoliticalParty> parties;
    private String errorMessage;
    private String successMessage;
    private static final Long NULL = -1L;
    private static final Long BLANK = -2L;

    public String getVoterDPI() {
        return voterDPI;
    }

    public void setVoterDPI(String voterDPI) {
        this.voterDPI = voterDPI;
    }
    
    public List<PoliticalParty> getParties() {
        parties = daoPoliticalParty.findAll();
        return parties;
    }

    public void setParties(List<PoliticalParty> parties) {
        this.parties = parties;
    }

    public Long getSelectedVoteOption() {
        return selectedVoteOption;
    }

    public void setSelectedVoteOption(Long selectedVoteOption) {
        this.selectedVoteOption = selectedVoteOption;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String getSuccessMessage() {
        return successMessage;
    }
    
    public Long getNullId() {
        return NULL;
    }
    
    public Long getBlankId() {
        return BLANK;
    }
    
    public void vote() {
        Voter v = daoVoter.findByDPI(voterDPI);
        //1) Verificar que el DPI existe
        //	1.1) Si no, ERROR
        if(v == null) {
            errorMessage = "El DPI ingresado no existe";
            return;
        }
        //2) Si sí existe, verificar que no haya votado, con el atributo ya_voto
        //	2.1) Si ya votó, ERROR
        if(v.getVoted()) {
            errorMessage = "El elector ya votó";
            return;
        }
        //3) Verificar la mesa del votante
        //	3.1) Si no tiene mesa asignada, ERROR
        VotingTable t = daoTable.findByVoter(voterDPI);
        if(t == null) {
            errorMessage = "El DPI ingresado no está empadronado";
            return;
        }
        
        //4) Validar VOTO NULO o VOTO EN BLANCO
        if(NULL.equals(selectedVoteOption)) {
            //	4.1) Si es VOTO NULO aumentar el contador de votos nulos de la mesa en cuestión
            t.increaseNullQuantity();
            daoTable.update(t);
            updateVoter(v);
            return;
        }
        if(BLANK.equals(selectedVoteOption)) {
            //	4.2) Si es VOTO EN BLANCO aumentar el contador de votos en blanco de la mesa en cuestión
            t.increaseBlankQuantity();
            daoTable.update(t);
            updateVoter(v);
            return;
        }
        
        //5) Crear el objeto VOTO (asignar mesa y partido político)
        PoliticalParty pp = daoPoliticalParty.findById(selectedVoteOption);
        Vote vote = new Vote();
        vote.setPoliticalParty(pp);
        vote.setVotingTable(t);
        
        //6) Persistir el objeto VOTO
        daoVote.submit(vote);
        
        //7) Actualizar el ya_voto del votante
        updateVoter(v);
        successMessage = "Voto emitido correctamente";
        errorMessage = null;
        voterDPI = null;
        selectedVoteOption = null;
    }
    
    private void updateVoter(Voter v) {
        v.setVoted(true);
        daoVoter.update(v);
    }

}
