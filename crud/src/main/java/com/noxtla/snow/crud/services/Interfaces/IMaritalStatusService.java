package com.noxtla.snow.crud.services.Interfaces;

import java.util.List;
import java.util.Optional;

import com.noxtla.snow.crud.models.MaritalStatus;

public interface IMaritalStatusService {

    MaritalStatus save (MaritalStatus estadoCivil);
    Optional <MaritalStatus> update (Long id, MaritalStatus estadoCivil);
    List<MaritalStatus> findAll();
    Optional <MaritalStatus> findById(Long id);
    Optional<MaritalStatus> delete(Long id);

}