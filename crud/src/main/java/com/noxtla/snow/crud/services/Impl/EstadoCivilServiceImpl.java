package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noxtla.snow.crud.models.EstadoCivil;
import com.noxtla.snow.crud.repositories.IEstadoCivilRepository;
import com.noxtla.snow.crud.services.Interfaces.IEstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements IEstadoCivilService{

    @Autowired
    private IEstadoCivilRepository estadoCivilRepository; 

    @Transactional
    @Override
    public EstadoCivil save(EstadoCivil estadoCivil) {
        
        return estadoCivilRepository.save(estadoCivil);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstadoCivil> findAll() {
        return (List<EstadoCivil>) estadoCivilRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstadoCivil> findById(Long id) {
        return estadoCivilRepository.findById(id);
    }

    @Override
    public Optional<EstadoCivil> delete(Long id) {
        Optional <EstadoCivil> estadoCivilOptional = estadoCivilRepository.findById(id);
        estadoCivilOptional.ifPresent(
            estadoCivilDB -> {
                estadoCivilRepository.delete(estadoCivilDB);
            }
        );
                return estadoCivilOptional;
    }

    @Override
    public Optional <EstadoCivil> update(Long id, EstadoCivil estadoCivil) {
        
        Optional <EstadoCivil> estadoCivilOptional = estadoCivilRepository.findById(id);
        if (estadoCivilOptional.isPresent()){
            EstadoCivil estadoCivilDB = estadoCivilOptional.orElseThrow();

            estadoCivilDB.setDescripcion_Estado_Civil(estadoCivil.getDescripcion_Estado_Civil());
            return Optional.of(estadoCivilRepository.save(estadoCivilDB));

        }

    return estadoCivilOptional;
    }

    

}
