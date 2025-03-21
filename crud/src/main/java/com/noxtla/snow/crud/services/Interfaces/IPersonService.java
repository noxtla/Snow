package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.DTO.PersonDTO;
import com.noxtla.snow.crud.models.Person;

public interface IPersonService {
    Person save (Person estadoCivil);

    Optional <Person> update (
        Long id, 
        Person person, 
        boolean actualizarNombre, 
        boolean actualizarTelefono,
        boolean actualizarFechaNacimiento, 
        boolean actualizarGenero,
        boolean actualizarEstadoCivil,
        boolean actualizarLugarNacimiento);

    List<Person> findAll();
    Optional <Person> findById(Long id);
    Optional<Person> delete(Long id);
    List<PersonDTO> findAllPersonDTOs();
}



