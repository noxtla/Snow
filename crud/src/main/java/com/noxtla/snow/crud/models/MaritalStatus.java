package com.noxtla.snow.crud.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class MaritalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marital_status")
    private Long id_marital_status;

    @Column(name = "description_marital_status")
    @NotEmpty()
    @Size(min=3, max=20)
    private String description_marital_status;

    /*
     * Aqui hay un monton mas de validaciones
     * Min(500) que es para validar que sea un entero y tambien para el valor minino
     * @Size(min=3, max=20) para string y para rango de tamanio
     * @notNull
     * @notBlank valida que no sea vacio y no mandes un espacio en blanco
     */

    @OneToMany(mappedBy = "marital_status_id_FK")
    private List<Person> personas; // ✅ Ahora es una colección

    public MaritalStatus() {
    }

    public MaritalStatus(String Descripcion_Estado_Civil) {
        this.description_marital_status = Descripcion_Estado_Civil;
    }

    public MaritalStatus(Long id, String Descripcion_Estado_Civil) {
        this.id_marital_status = id;
        this.description_marital_status = Descripcion_Estado_Civil;
    }

    public Long getId_marital_status() {
        return id_marital_status;
    }

    public void setId_marital_status(Long id) {
        this.id_marital_status = id;
    }

    public String getDescription_marital_status() { // ✅ Ahora coincide con el atributo
        return description_marital_status;
    }

    public void setDescription_marital_status(String Descripcion_Estado_Civil) {
        this.description_marital_status = Descripcion_Estado_Civil;
    }

}