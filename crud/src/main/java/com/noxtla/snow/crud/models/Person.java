package com.noxtla.snow.crud.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Person;

    String first_name;
    String middle_name;
    String last_name;
    String second_last_name;
    Long mobile_phone;
    Date birth_date;

    @ManyToOne
    @JoinColumn(name = "gender_id_FK", nullable = false)
    /// Lo que pondas en name es como se va a referenciar
    /// Si esta id_genero_X asi se ve en SQL
    /// si lo comentas seria genero_id_genero
    private Gender gender_id_FK;

    @ManyToOne
    @JoinColumn(name = "marital_status_id_FK", nullable = false)
    private MaritalStatus marital_status_id_FK;

    @ManyToOne
    @JoinColumn(name = "birthplace_id_FK", nullable = false)
    private BirthPlace birthplace_id_FK;

    public Person(Long id, String primer_Nombre, String segundo_Nombre, String apellido_Paterno,
            String apellido_Materno, Long telefono_Celular, Date fechaNacimiento, MaritalStatus estadoCivil,
            BirthPlace lugar_nacimiento, Gender genero) {
        this.id_Person = id;
        this.first_name = primer_Nombre;
        this.middle_name = segundo_Nombre;
        this.last_name = apellido_Paterno;
        this.second_last_name = apellido_Materno;
        this.mobile_phone = telefono_Celular;
        this.birth_date = fechaNacimiento;
        this.marital_status_id_FK = estadoCivil;
        this.birthplace_id_FK = lugar_nacimiento;
        this.gender_id_FK = genero;
    }

    public Person() {
    }

    public Person(Long id, String primer_Nombre, String segundo_Nombre, String apellido_Paterno,
            String apellido_Materno, Long telefono_Celular) {
        this.id_Person = id;
        this.first_name = primer_Nombre;
        this.middle_name = segundo_Nombre;
        this.last_name = apellido_Paterno;
        this.second_last_name = apellido_Materno;
        this.mobile_phone = telefono_Celular;
    }

    public Long getId_Person() {
        return id_Person;
    }

    public void setId_Person(Long id_Person) {
        this.id_Person = id_Person;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public Long getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(Long mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Gender getGender_id_FK() {
        return gender_id_FK;
    }

    public void setGender_id_FK(Gender gender_id_FK) {
        this.gender_id_FK = gender_id_FK;
    }

    public MaritalStatus getMarital_status_id_FK() {
        return marital_status_id_FK;
    }

    public void setMarital_status_id_FK(MaritalStatus marital_status_id_FK) {
        this.marital_status_id_FK = marital_status_id_FK;
    }

    public BirthPlace getBirthplace_id_FK() {
        return birthplace_id_FK;
    }

    public void setBirthplace_id_FK(BirthPlace birthplace_id_FK) {
        this.birthplace_id_FK = birthplace_id_FK;
    }
   
}
