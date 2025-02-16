package com.noxtla.snow.crud.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lugar_Nacimiento")
public class LugarNacimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lugar_nacimiento;

    @JsonProperty("ciudad")
    private String Ciudad;

    @JsonProperty("estado")
    private String Estado;

    @JsonProperty("pais")
    private String Pais;

    @OneToMany(mappedBy = "lugar_nacimiento")
    private List<Persona> personas; // ✅ Relacion uno a muchos persona-Lugar de nacimiento
    
    public LugarNacimiento() {

    }

    public LugarNacimiento(Long id, String ciudad, String estado, String pais) {
        this.id_lugar_nacimiento = id;
        this.Ciudad = ciudad;
        this.Estado = estado;
        this.Pais = pais;
    }

    public Long getId_lugar_nacimiento() {
        return id_lugar_nacimiento;
    }

    public void setId_lugar_nacimiento(Long id) {
        this.id_lugar_nacimiento = id;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

}