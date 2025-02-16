package com.noxtla.snow.crud.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Persona;

    String Primer_Nombre;
    String Segundo_Nombre;
    String Apellido_Paterno;
    String Apellido_Materno;
    Long Telefono_Celular;
    Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    /// Lo que pondas en name es como se va a referenciar
    /// Si esta id_genero_X asi se ve en SQL
    /// si lo comentas seria genero_id_genero
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private EstadoCivil estado_civil;

    @ManyToOne
    @JoinColumn(name = "id_lugar_nacimiento", nullable = false)
    private LugarNacimiento lugar_nacimiento;

    public Persona(Long id, String primer_Nombre, String segundo_Nombre, String apellido_Paterno,
            String apellido_Materno, Long telefono_Celular, Date fechaNacimiento, EstadoCivil estadoCivil, LugarNacimiento lugar_nacimiento, Genero genero ) {
        this.id_Persona = id;
        this.Primer_Nombre = primer_Nombre;
        this.Segundo_Nombre = segundo_Nombre;
        this.Apellido_Paterno = apellido_Paterno;
        this.Apellido_Materno = apellido_Materno;
        this.Telefono_Celular = telefono_Celular;
        this.fechaNacimiento = fechaNacimiento;
        this.estado_civil = estadoCivil;
        this.lugar_nacimiento = lugar_nacimiento;
        this.genero = genero;
    }

    public Persona() {
    }

    public Persona(Long id, String primer_Nombre, String segundo_Nombre, String apellido_Paterno,
            String apellido_Materno, Long telefono_Celular) {
        this.id_Persona = id;
        this.Primer_Nombre = primer_Nombre;
        this.Segundo_Nombre = segundo_Nombre;
        this.Apellido_Paterno = apellido_Paterno;
        this.Apellido_Materno = apellido_Materno;
        this.Telefono_Celular = telefono_Celular;
    }

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id) {
        this.id_Persona = id;
    }

    public String getPrimer_Nombre() {
        return Primer_Nombre;
    }

    public void setPrimer_Nombre(String primer_Nombre) {
        this.Primer_Nombre = primer_Nombre;
    }

    public String getSegundo_Nombre() {
        return Segundo_Nombre;
    }

    public void setSegundo_Nombre(String segundo_Nombre) {
        Segundo_Nombre = segundo_Nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.Apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.Apellido_Materno = apellido_Materno;
    }

    public Long getTelefono_Celular() {
        return Telefono_Celular;
    }

    public void setTelefono_Celular(Long telefono_Celular) {
        this.Telefono_Celular = telefono_Celular;
    }

}
