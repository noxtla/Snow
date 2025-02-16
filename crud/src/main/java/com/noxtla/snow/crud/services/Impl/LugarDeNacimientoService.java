package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noxtla.snow.crud.models.LugarNacimiento;
import com.noxtla.snow.crud.repositories.ILugarNacimientoRepositoy;
import com.noxtla.snow.crud.services.Interfaces.ILugarDeNacimientoService;

@Service
public class LugarDeNacimientoService implements ILugarDeNacimientoService {

    @Autowired
    private ILugarNacimientoRepositoy lugarNacimientoRepository;

    @Override
    public LugarNacimiento save(LugarNacimiento lugarNacimiento) {
        return lugarNacimientoRepository.save(lugarNacimiento);
    }

    @Override
    public Optional<LugarNacimiento> update(Long id, LugarNacimiento lugarNacimiento, boolean actualizarCiudad, boolean actualizarEstado, boolean actualizarPais) {
    
    Optional<LugarNacimiento> lugarNacimientoOptional = lugarNacimientoRepository.findById(id);
    if (lugarNacimientoOptional.isPresent()) {
        LugarNacimiento lugarNacimientoDB = lugarNacimientoOptional.orElseThrow();

        if (actualizarCiudad && !lugarNacimiento.getCiudad().equals(lugarNacimientoDB.getCiudad())) {
            lugarNacimientoDB.setCiudad(lugarNacimiento.getCiudad());
        }
        
        if (actualizarEstado && !lugarNacimiento.getEstado().equals(lugarNacimientoDB.getEstado())) {
            lugarNacimientoDB.setEstado(lugarNacimiento.getEstado());
        }
        
        if (actualizarPais && !lugarNacimiento.getPais().equals(lugarNacimientoDB.getPais())) {
            lugarNacimientoDB.setPais(lugarNacimiento.getPais());
        }

        return Optional.of(lugarNacimientoRepository.save(lugarNacimientoDB));
    }

    return lugarNacimientoOptional;
}
        
    @Override
    public Optional<LugarNacimiento> delete(Long id) {
        Optional<LugarNacimiento> optionalLugarNacimiento = lugarNacimientoRepository.findById(id);

        optionalLugarNacimiento.ifPresent(
                lugarNacimientoDB -> {
                    lugarNacimientoRepository.delete(lugarNacimientoDB);
                });

        return optionalLugarNacimiento;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LugarNacimiento> findById(Long id) {
        return lugarNacimientoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LugarNacimiento> findAll() {
        return (List<LugarNacimiento>) lugarNacimientoRepository.findAll();
    }

}
