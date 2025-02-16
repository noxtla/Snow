package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.models.BirthPlace;

public interface IBirthPlaceService {

    BirthPlace save(BirthPlace lugarNacimiento);
    Optional<BirthPlace> update (Long id, BirthPlace estadoCivil,boolean actualizarCiudad, boolean actualizarEstado, boolean actualizarPais);
    List<BirthPlace> findAll();
    Optional<BirthPlace> findById(Long id);
    Optional<BirthPlace> delete (Long id);

}

