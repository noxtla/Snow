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
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EstadoCivil")
    private Long id_estado_civil;

    @Column(name = "descripcion_estado_civil")
    @NotEmpty()
    @Size(min=3, max=20)
    private String Descripcion_Estado_Civil;

    /*
     * Aqui hay un monton mas de validaciones
     * Min(500) que es para validar que sea un entero y tambien para el valor minino
     * @Size(min=3, max=20) para string y para rango de tamanio
     * @notNull
     * @notBlank valida que no sea vacio y no mandes un espacio en blanco
     */

    @OneToMany(mappedBy = "estado_civil")
    private List<Persona> personas; // ✅ Ahora es una colección

    public EstadoCivil() {
    }

    public EstadoCivil(String Descripcion_Estado_Civil) {
        this.Descripcion_Estado_Civil = Descripcion_Estado_Civil;
    }

    public EstadoCivil(Long id, String Descripcion_Estado_Civil) {
        this.id_estado_civil = id;
        this.Descripcion_Estado_Civil = Descripcion_Estado_Civil;
    }

    public Long getId_estado_civil() {
        return id_estado_civil;
    }

    public void setId_estado_civil(Long id) {
        this.id_estado_civil = id;
    }

    public String getDescripcion_Estado_Civil() { // ✅ Ahora coincide con el atributo
        return Descripcion_Estado_Civil;
    }

    public void setDescripcion_Estado_Civil(String Descripcion_Estado_Civil) {
        this.Descripcion_Estado_Civil = Descripcion_Estado_Civil;
    }

}