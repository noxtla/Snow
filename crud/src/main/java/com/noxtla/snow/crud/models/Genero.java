package com.noxtla.snow.crud.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;

    private String Descripcion;

    @OneToMany(mappedBy = "genero")
    private List<Persona> personas; // ✅ Ahora es una colección

    public Genero() {
    }

    public Genero(Long id, String descripcion) {
        this.id_genero = id;
        Descripcion = descripcion;
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id) {
        this.id_genero = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

}
