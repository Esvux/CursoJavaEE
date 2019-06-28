package com.academik.minitse.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "voto")
public class Vote implements Serializable {
    
    @Id
    @Column(name = "id_voto")
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido", nullable = false)
    private PoliticalParty politicalParty;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa", nullable = false)
    private VotingTable votingTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public VotingTable getVotingTable() {
        return votingTable;
    }

    public void setVotingTable(VotingTable votingTable) {
        this.votingTable = votingTable;
    }
    
}
