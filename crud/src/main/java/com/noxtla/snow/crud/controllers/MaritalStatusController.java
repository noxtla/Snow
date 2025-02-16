package com.noxtla.snow.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noxtla.snow.crud.models.MaritalStatus;
import com.noxtla.snow.crud.services.Interfaces.IMaritalStatusService;
import com.noxtla.snow.crud.utils.ValidationUtils;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/maritalStatus")
public class MaritalStatusController {

    @Autowired
    private IMaritalStatusService maritalSatatusService;

    @Autowired
    private ValidationUtils validationUtils;

    @GetMapping("/listAll")
    public List<MaritalStatus> listEstadoCivil() {
        return maritalSatatusService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<MaritalStatus> productOptional = maritalSatatusService.findById(id);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody MaritalStatus estadoCivil, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(maritalSatatusService.save(estadoCivil));

    }

    @PutMapping("/{id}")
    public ResponseEntity <?> update (@Valid @RequestBody MaritalStatus estadoCivil, BindingResult result, @PathVariable Long id){
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        Optional <MaritalStatus> estadoCivilOptional = maritalSatatusService.update(id, estadoCivil);
        if (estadoCivilOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoCivilOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<MaritalStatus> maritalStatusOptional = maritalSatatusService.delete(id);

        if (maritalStatusOptional.isPresent()) {
            return ResponseEntity.ok(maritalStatusOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
