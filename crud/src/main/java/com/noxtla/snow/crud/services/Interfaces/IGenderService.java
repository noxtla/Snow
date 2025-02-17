package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.models.Gender;

public interface IGenderService {

    Gender save (Gender genero);
    Optional<Gender> update (Long id, Gender genero);
    List<Gender> findAll();
    Optional<Gender> findById(Long id);
    Optional<Gender> delete (Long id);


}
