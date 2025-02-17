package com.noxtla.snow.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noxtla.snow.crud.models.Person;
import com.noxtla.snow.crud.services.Interfaces.IPersonService;
import com.noxtla.snow.crud.utils.ValidationUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private IPersonService personaService;

    @Autowired
    private ValidationUtils validationUtils;

    @GetMapping("/listAll")
    public List<Person> listEstadoCivil() {
        return personaService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Person perona, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(perona));
    }

}
