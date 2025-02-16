package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.models.LugarNacimiento;

public interface ILugarDeNacimientoService {

    LugarNacimiento save(LugarNacimiento lugarNacimiento);
    Optional<LugarNacimiento> update (Long id, LugarNacimiento estadoCivil,boolean actualizarCiudad, boolean actualizarEstado, boolean actualizarPais);
    List<LugarNacimiento> findAll();
    Optional<LugarNacimiento> findById(Long id);
    Optional<LugarNacimiento> delete (Long id);

}

