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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "centro_votacion")
public class VotingPlace implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_voting_place", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_voting_place")
    @Column(name = "id_centro")
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String name;
    
    @Column(name = "direccion", nullable = false, length = 500)
    private String address;
    
    @Column(name = "direccion_extra", length = 500)
    private String extraAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipality municipality;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "votingPlace")
    private List<VotingTable> tables;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtraAddress() {
        return extraAddress;
    }

    public void setExtraAddress(String extraAddress) {
        this.extraAddress = extraAddress;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
    
    public List<VotingTable> getTables() {
        return tables;
    }

    public void setTables(List<VotingTable> tables) {
        this.tables = tables;
    }

}
