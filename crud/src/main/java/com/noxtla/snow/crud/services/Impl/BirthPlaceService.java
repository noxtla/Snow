package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noxtla.snow.crud.models.BirthPlace;
import com.noxtla.snow.crud.repositories.IBirthPlaceRepository;
import com.noxtla.snow.crud.services.Interfaces.IBirthPlaceService;

@Service
public class BirthPlaceService implements IBirthPlaceService {

    @Autowired
    private IBirthPlaceRepository lugarNacimientoRepository;

    @Override
    public BirthPlace save(BirthPlace lugarNacimiento) {
        return lugarNacimientoRepository.save(lugarNacimiento);
    }

    @Override
    public Optional<BirthPlace> update(Long id, BirthPlace lugarNacimiento, boolean actualizarCiudad, boolean actualizarEstado, boolean actualizarPais) {
    
    Optional<BirthPlace> lugarNacimientoOptional = lugarNacimientoRepository.findById(id);
    if (lugarNacimientoOptional.isPresent()) {
        BirthPlace lugarNacimientoDB = lugarNacimientoOptional.orElseThrow();

        if (actualizarCiudad && !lugarNacimiento.getCity().equals(lugarNacimientoDB.getCity())) {
            lugarNacimientoDB.setCity(lugarNacimiento.getCity());
        }
        
        if (actualizarEstado && !lugarNacimiento.getState().equals(lugarNacimientoDB.getState())) {
            lugarNacimientoDB.setState(lugarNacimiento.getState());
        }
        
        if (actualizarPais && !lugarNacimiento.getCountry().equals(lugarNacimientoDB.getCountry())) {
            lugarNacimientoDB.setCountry(lugarNacimiento.getCountry());
        }

        return Optional.of(lugarNacimientoRepository.save(lugarNacimientoDB));
    }

    return lugarNacimientoOptional;
}
        
    @Override
    public Optional<BirthPlace> delete(Long id) {
        Optional<BirthPlace> optionalLugarNacimiento = lugarNacimientoRepository.findById(id);

        optionalLugarNacimiento.ifPresent(
                lugarNacimientoDB -> {
                    lugarNacimientoRepository.delete(lugarNacimientoDB);
                });

        return optionalLugarNacimiento;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BirthPlace> findById(Long id) {
        return lugarNacimientoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BirthPlace> findAll() {
        return (List<BirthPlace>) lugarNacimientoRepository.findAll();
    }

}
