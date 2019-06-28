package com.academik.minitse.model;

import java.io.Serializable;
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
@Table(name = "municipio")
public class Municipality implements Serializable {

    @Id
    @Column(name = "id_municipio")
    private Long id;
    
    @Column(name = "nombre")
    private String name;
    
    //Define la estrategia para recolectar la informacion
    //de la otra tabla (departamento), si es LAZY, JPA busca
    //la informacion hasta que se requiere explicitamente
    @ManyToOne(fetch = FetchType.LAZY)
    //Que columna de la tabla municipio recibe
    //el valor de la llave foranea de departamento
    @JoinColumn(name = "id_departamento", nullable = false)
    private Department department;

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
    
}
