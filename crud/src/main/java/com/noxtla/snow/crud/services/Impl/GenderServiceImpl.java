package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noxtla.snow.crud.models.Gender;
import com.noxtla.snow.crud.repositories.IGenderRepository;
import com.noxtla.snow.crud.services.Interfaces.IGenderService;

@Service
public class GenderServiceImpl implements IGenderService{

    @Autowired
    IGenderRepository generoRepository;

    @Override
    public Gender save(Gender genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Optional<Gender> update(Long id, Gender genero) {
         Optional <Gender> genderOptional = generoRepository.findById(id);
        if (genderOptional.isPresent()){
            Gender genderDB = genderOptional.orElseThrow();

            genderDB.setDescription_gender(genero.getDescription_gender());
            return Optional.of(generoRepository.save(genderDB));

        }
        return genderOptional;
    }

    @Override
    public List<Gender> findAll() {
        return (List<Gender>) generoRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public Optional<Gender> delete(Long id) {
        Optional <Gender> generoOptional = generoRepository.findById(id);
        generoOptional.ifPresent(
            genreDB -> {
                generoRepository.delete(genreDB);
            }
        );
                return generoOptional;
    }
    

}
