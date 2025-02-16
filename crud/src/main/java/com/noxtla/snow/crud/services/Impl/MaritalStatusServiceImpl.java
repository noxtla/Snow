package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noxtla.snow.crud.models.MaritalStatus;
import com.noxtla.snow.crud.repositories.IMaritalStatusRepository;
import com.noxtla.snow.crud.services.Interfaces.IMaritalStatusService;

@Service
public class MaritalStatusServiceImpl implements IMaritalStatusService{

    @Autowired
    private IMaritalStatusRepository maritalSatatusRepository; 

    @Transactional
    @Override
    public MaritalStatus save(MaritalStatus estadoCivil) {
        
        return maritalSatatusRepository.save(estadoCivil);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MaritalStatus> findAll() {
        return (List<MaritalStatus>) maritalSatatusRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MaritalStatus> findById(Long id) {
        return maritalSatatusRepository.findById(id);
    }

    @Override
    public Optional<MaritalStatus> delete(Long id) {
        Optional <MaritalStatus> estadoCivilOptional = maritalSatatusRepository.findById(id);
        estadoCivilOptional.ifPresent(
            estadoCivilDB -> {
                maritalSatatusRepository.delete(estadoCivilDB);
            }
        );
                return estadoCivilOptional;
    }

    @Override
    public Optional <MaritalStatus> update(Long id, MaritalStatus estadoCivil) {
        
        Optional <MaritalStatus> estadoCivilOptional = maritalSatatusRepository.findById(id);
        if (estadoCivilOptional.isPresent()){
            MaritalStatus estadoCivilDB = estadoCivilOptional.orElseThrow();

            estadoCivilDB.setDescription_marital_status(estadoCivil.getDescription_marital_status());
            return Optional.of(maritalSatatusRepository.save(estadoCivilDB));

        }

    return estadoCivilOptional;
    }

}
