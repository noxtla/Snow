package com.noxtla.snow.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noxtla.snow.crud.models.ClientData;
import com.noxtla.snow.crud.services.Interfaces.IClienteDataService;
import com.noxtla.snow.crud.utils.ValidationUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/clientData")
public class ClientDataController {

    @Autowired
    private IClienteDataService clienteDataService;

    @Autowired
    private ValidationUtils validationUtils;

    @GetMapping("/listAll")
    public List<ClientData> listAll() {
        return clienteDataService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ClientData clientData, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDataService.save(clientData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Valid @RequestBody ClientData clientData,
            BindingResult result,
            @PathVariable Long id) {

        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }

        Optional<ClientData> clientDataOptional = clienteDataService.update(id, clientData);

        if (clientDataOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientDataOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<ClientData> clientDataOptional = clienteDataService.delete(id);

        if (clientDataOptional.isPresent()) {
            return ResponseEntity.ok(clientDataOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<ClientData> clientDataOptional = clienteDataService.findById(id);

        if (clientDataOptional.isPresent()) {
            return ResponseEntity.ok(clientDataOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}