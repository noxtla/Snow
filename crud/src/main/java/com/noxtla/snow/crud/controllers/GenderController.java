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

import com.noxtla.snow.crud.models.Gender;
import com.noxtla.snow.crud.services.Interfaces.IGenderService;
import com.noxtla.snow.crud.utils.ValidationUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/gender")
public class GenderController {

    @Autowired
    private IGenderService genderService;

    @Autowired
    private ValidationUtils validationUtils;

    @GetMapping("/listAll")
    public List<Gender> listGender() {
        return genderService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Gender> productOptional = genderService.findById(id);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Gender estadoCivil, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(genderService.save(estadoCivil));

    }

    @PutMapping("/{id}")
    public ResponseEntity <?> update (@Valid @RequestBody Gender estadoCivil, BindingResult result, @PathVariable Long id){
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        Optional <Gender> estadoCivilOptional = genderService.update(id, estadoCivil);
        if (estadoCivilOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoCivilOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Gender> maritalStatusOptional = genderService.delete(id);

        if (maritalStatusOptional.isPresent()) {
            return ResponseEntity.ok(maritalStatusOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
