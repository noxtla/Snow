package com.noxtla.snow.crud.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noxtla.snow.crud.models.ClientData;
import com.noxtla.snow.crud.repositories.IClientDataRepository;
import com.noxtla.snow.crud.services.Interfaces.IClienteDataService;

@Service
public class ClienteDataServiceImpl implements IClienteDataService {

    @Autowired
    private IClientDataRepository clienteDataRepository;

    @Override
    public ClientData save(ClientData clientData) {
        return clienteDataRepository.save(clientData);
    }

    @Override
    public Optional<ClientData> update(Long id, ClientData clientData) {
        Optional<ClientData> existingClientData = clienteDataRepository.findById(id);

        if (existingClientData.isPresent()) {
            ClientData clientDataDB = existingClientData.orElseThrow();

            // Actualizar solo los campos que no sean nulos en el objeto recibido
            if (clientData.getPassportNumber() != null) {
                clientDataDB.setPassportNumber(clientData.getPassportNumber());
            }
            if (clientData.getEmail() != null) {
                clientDataDB.setEmail(clientData.getEmail());
            }
            if (clientData.getHasUsedOtherNames() != null) {
                clientDataDB.setHasUsedOtherNames(clientData.getHasUsedOtherNames());
            }
            if (clientData.getOtherNationality() != null) {
                clientDataDB.setOtherNationality(clientData.getOtherNationality());
            }
            if (clientData.getUsSocialSecurityNumber() != null) {
                clientDataDB.setUsSocialSecurityNumber(clientData.getUsSocialSecurityNumber());
            }
            if (clientData.getTaxpayerId() != null) {
                clientDataDB.setTaxpayerId(clientData.getTaxpayerId());
            }
            if (clientData.getVisaType() != null) {
                clientDataDB.setVisaType(clientData.getVisaType());
            }
            if (clientData.getPassportPhoto() != null) {
                clientDataDB.setPassportPhoto(clientData.getPassportPhoto());
            }
            if (clientData.getMemo() != null) {
                clientDataDB.setMemo(clientData.getMemo());
            }

            return Optional.of(clienteDataRepository.save(clientDataDB));
        }

        return Optional.empty();
    }

    @Override
    public List<ClientData> findAll() {
        return clienteDataRepository.findAll();
    }

    @Override
    public Optional<ClientData> findById(Long id) {
        return clienteDataRepository.findById(id);
    }

    @Override
    public Optional<ClientData> delete(Long id) {
        Optional<ClientData> clientDataOptional = clienteDataRepository.findById(id);

        if (clientDataOptional.isPresent()) {
            clienteDataRepository.deleteById(id);
        }

        return clientDataOptional;
    }
}