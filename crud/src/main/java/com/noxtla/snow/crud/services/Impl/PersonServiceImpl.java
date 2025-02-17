package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noxtla.snow.crud.models.Person;
import com.noxtla.snow.crud.repositories.IPersonRepository;
import com.noxtla.snow.crud.services.Interfaces.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public Person save(Person persona) {
        return personRepository.save(persona);
    }

    @Override
    public Optional<Person> update(Long id, Person person, boolean actualizarNombre, boolean actualizarTelefono,
            boolean actualizarFechaNacimiento, boolean actualizarGenero,
            boolean actualizarEstadoCivil, boolean actualizarLugarNacimiento) {

        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isPresent()) {
            Person personDB = personOptional.orElseThrow();

            if (actualizarNombre) {
                if (!person.getFirst_name().equals(personDB.getFirst_name())) {
                    personDB.setFirst_name(person.getFirst_name());
                }
                if (!person.getMiddle_name().equals(personDB.getMiddle_name())) {
                    personDB.setMiddle_name(person.getMiddle_name());
                }
                if (!person.getLast_name().equals(personDB.getLast_name())) {
                    personDB.setLast_name(person.getLast_name());
                }
                if (!person.getSecond_last_name().equals(personDB.getSecond_last_name())) {
                    personDB.setSecond_last_name(person.getSecond_last_name());
                }
            }

            if (actualizarTelefono && !person.getMobile_phone().equals(personDB.getMobile_phone())) {
                personDB.setMobile_phone(person.getMobile_phone());
            }

            if (actualizarFechaNacimiento && !person.getBirth_date().equals(personDB.getBirth_date())) {
                personDB.setBirth_date(person.getBirth_date());
            }

            if (actualizarGenero && !person.getGender_id_FK().equals(personDB.getGender_id_FK())) {
                personDB.setGender_id_FK(person.getGender_id_FK());
            }

            if (actualizarEstadoCivil && !person.getMarital_status_id_FK().equals(personDB.getMarital_status_id_FK())) {
                personDB.setMarital_status_id_FK(person.getMarital_status_id_FK());
            }

            if (actualizarLugarNacimiento && !person.getBirthplace_id_FK().equals(personDB.getBirthplace_id_FK())) {
                personDB.setBirthplace_id_FK(person.getBirthplace_id_FK());
            }

            return Optional.of(personRepository.save(personDB));
        }

        return personOptional;
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<Person> delete(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        personOptional.ifPresent(
                estadoCivilDB -> {
                    personRepository.delete(estadoCivilDB);
                });
        return personOptional;
    }

}
