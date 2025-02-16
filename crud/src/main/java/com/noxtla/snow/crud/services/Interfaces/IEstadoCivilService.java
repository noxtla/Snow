package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.models.EstadoCivil;

public interface IEstadoCivilService {

    EstadoCivil save (EstadoCivil estadoCivil);
    Optional <EstadoCivil> update (Long id, EstadoCivil estadoCivil);
    List<EstadoCivil> findAll();
    Optional <EstadoCivil> findById(Long id);
    Optional<EstadoCivil> delete(Long id);

}