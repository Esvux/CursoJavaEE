package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voteSubmitBean")
@RequestScoped
public class VoteSubmitBean {
    
    @Inject
    PoliticalPartyDAO dao;
    
    private List<PoliticalParty> parties;
    private Long selectedVoteOption;

    public List<PoliticalParty> getParties() {
        parties = dao.findAll();
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
    
    public void vote() {
        System.out.println("Usted esta votando por: " + selectedVoteOption);
    }

}
