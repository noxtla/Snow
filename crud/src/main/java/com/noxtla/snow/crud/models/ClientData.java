package com.noxtla.snow.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
public class ClientData {

    @Id
    @Column(name = "client_id")
    private long clientId; 

    @Column(name = "passport_number", length = 50)
    private String passportNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "has_used_other_names", nullable = false)
    private String hasUsedOtherNames;

    @Column(name = "other_nationality", length = 255)
    private String otherNationality;

    @Column(name = "us_social_security_number", length = 50)
    private String usSocialSecurityNumber;

    @Column(name = "taxpayer_id", length = 50)
    private String taxpayerId;

    @Column(name = "visa_type", length = 50)
    private String visaType;

    @Lob
    @Column(name = "passport_photo")
    private byte[] passportPhoto;

    @Column(name = "memo", columnDefinition = "TEXT")
    private String memo;

     // Relación con la tabla person
     @OneToOne
     @MapsId
     @JoinColumn(name = "client_id", referencedColumnName = "id_person")
     private Person person;

    // Getters y Setters
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHasUsedOtherNames() {
        return hasUsedOtherNames;
    }

    public void setHasUsedOtherNames(String hasUsedOtherNames) {
        this.hasUsedOtherNames = hasUsedOtherNames;
    }

    public String getOtherNationality() {
        return otherNationality;
    }

    public void setOtherNationality(String otherNationality) {
        this.otherNationality = otherNationality;
    }

    public String getUsSocialSecurityNumber() {
        return usSocialSecurityNumber;
    }

    public void setUsSocialSecurityNumber(String usSocialSecurityNumber) {
        this.usSocialSecurityNumber = usSocialSecurityNumber;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public byte[] getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(byte[] passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}