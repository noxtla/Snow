package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noxtla.snow.crud.models.Gender;
import com.noxtla.snow.crud.models.Person;
import com.noxtla.snow.crud.repositories.IPersonRepository;
import com.noxtla.snow.crud.services.Interfaces.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    IPersonRepository personRepository;

    @Override
    public Person save(Person persona) {
        return personRepository.save(persona);
    }

    @Override
    public Optional<Person> update(Long id, Person estadoCivil) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<Person> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
