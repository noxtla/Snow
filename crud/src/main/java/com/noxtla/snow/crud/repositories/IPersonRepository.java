package com.noxtla.snow.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.noxtla.snow.crud.models.Person;

public interface IPersonRepository extends CrudRepository<Person,Long>{

}
