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
@Table(name = "birthplace")
public class BirthPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_birthplace;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @OneToMany(mappedBy = "birthplace_id_FK")
    private List<Person> personas; // ✅ Relacion uno a muchos persona-Lugar de nacimiento
    
    public BirthPlace() {

    }

    public BirthPlace(Long id_birthplace, String city, String state, String country) {
        this.id_birthplace = id_birthplace;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId_birthplace() {
        return id_birthplace;
    }

    public void setId_birthplace(Long id_birthplace) {
        this.id_birthplace = id_birthplace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}