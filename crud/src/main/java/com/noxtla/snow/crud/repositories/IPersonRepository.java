package com.noxtla.snow.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noxtla.snow.crud.DTO.PersonDTO;
import com.noxtla.snow.crud.models.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p.first_name AS firstName, p.middle_name AS middleName FROM Person p", nativeQuery = true)
    List<PersonDTO> findAllPersonDTOs();
}
