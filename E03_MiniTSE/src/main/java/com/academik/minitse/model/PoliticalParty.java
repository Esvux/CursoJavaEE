package com.academik.minitse.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "partido")
public class PoliticalParty implements Serializable {
    
    @Id
    @Column(name = "id_partido")
    private Long id;
    
    @Column(name = "nombre")
    private String name;
    
    @Column(name = "nombre_candidato")
    private String candidate;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "politicalParty")
    private List<Vote> votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
}
