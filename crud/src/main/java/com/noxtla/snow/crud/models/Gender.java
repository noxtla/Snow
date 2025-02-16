package com.noxtla.snow.crud.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gender;

    private String description_gender;

    @OneToMany(mappedBy = "gender_id_FK")
    private List<Person> personas; // ✅ Ahora es una colección

    public Gender() {
    }

    public Gender(Long id, String descripcion) {
        this.id_gender = id;
        description_gender = descripcion;
    }

    public Long getId_gender() {
        return id_gender;
    }

    public void setId_gender(Long id_gender) {
        this.id_gender = id_gender;
    }

    public String getDescription_gender() {
        return description_gender;
    }

    public void setDescription_gender(String description_gender) {
        this.description_gender = description_gender;
    }

}
