package com.academik.rest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de la tabla graduacion.
 * @author esvux
 */
@Table(name = "graduacion")
@Entity
public class Graduacion implements Serializable {
    
    @Id
    @Column(name = "correlativo_estudiante")
    private Long correlativo;

    @Column(name = "nombre_carrera")
    private String carrera;

    @Column(name = "fecha_publico")
    private String fechaPublico;

    @Column
    private Character genero;
    
    @Column(name = "pais_nacionalidad")
    private String nacionalidad;
    
    @Column(name = "anio_nacimiento")
    private int anioNac;

    @Column(name = "anio_ingreso_carrera")
    private int anioIng;

    @Column(name = "promedio_al_graduarse")
    private String promedio;

    public Long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Long correlativo) {
        this.correlativo = correlativo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechaPublico() {
        return fechaPublico;
    }

    public void setFechaPublico(String fechaPublico) {
        this.fechaPublico = fechaPublico;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(int anioNac) {
        this.anioNac = anioNac;
    }

    public int getAnioIng() {
        return anioIng;
    }

    public void setAnioIng(int anioIng) {
        this.anioIng = anioIng;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }
    
    
}
