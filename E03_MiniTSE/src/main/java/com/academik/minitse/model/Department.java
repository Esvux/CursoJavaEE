package com.academik.minitse.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "departamento")
public class Department implements Serializable {
    
    @Id
    @Column(name = "id_departamento")
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "department")
    private List<Municipality> municipalities;

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

    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<Municipality> municipalities) {
        this.municipalities = municipalities;
    }
    
}
