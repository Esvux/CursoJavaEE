package com.academik.minitse.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @OneToMany(
            cascade = CascadeType.ALL, 
            orphanRemoval = true, 
            mappedBy = "municipality"
    )
    //cascade > Determina como se manejaran las operaciones en cascada de las tablas
    //orphanRemoval > Determina si las tuplas de las tablas "hijas" se eliminan
    //cuando se elimina el registro "padre"
    //mappedBy > Le dice a JPA como se llama el atributo que mapea la misma 
    //relacion en la otra tabla para este caso la clase VotingPlace tendra un 
    //atributo de tipo Municipality que mapea la otra mitad de la relacion
    private List<VotingPlace> centers;

    public Municipality() {
    }

    public Municipality(Long id) {
        this.id = id;
    }   
    
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<VotingPlace> getCenters() {
        return centers;
    }

    public void setCenters(List<VotingPlace> centers) {
        this.centers = centers;
    }
    
}
