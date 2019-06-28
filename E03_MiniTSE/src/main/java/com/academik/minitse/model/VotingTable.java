package com.academik.minitse.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "mesa_votacion")
public class VotingTable implements Serializable {
    
    @Id
    @Column(name = "id_mesa")
    private Long id;
    
    @Column(name = "num_mesa", nullable = false, unique = true)
    private Integer tableNum;
    
    @Column(name = "cantidad_nulos", nullable = false)
    private Integer nullQuantity;
    
    @Column(name = "cantidad_blancos", nullable = false)
    private Integer blankQuantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro", nullable = false)
    private VotingPlace votingPlace;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "votingTable")
    private List<Vote> votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public Integer getNullQuantity() {
        return nullQuantity;
    }

    public void setNullQuantity(Integer nullQuantity) {
        this.nullQuantity = nullQuantity;
    }

    public Integer getBlankQuantity() {
        return blankQuantity;
    }

    public void setBlankQuantity(Integer blankQuantity) {
        this.blankQuantity = blankQuantity;
    }

    public VotingPlace getVotingPlace() {
        return votingPlace;
    }

    public void setVotingPlace(VotingPlace votingPlace) {
        this.votingPlace = votingPlace;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
}
