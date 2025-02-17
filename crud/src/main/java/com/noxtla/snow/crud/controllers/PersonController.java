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
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Valid @RequestBody Person person,
            BindingResult result,
            @PathVariable Long id,
            @RequestParam(defaultValue = "false") boolean actualizarNombre,
            @RequestParam(defaultValue = "false") boolean actualizarTelefono,
            @RequestParam(defaultValue = "false") boolean actualizarFechaNacimiento,
            @RequestParam(defaultValue = "false") boolean actualizarGenero,
            @RequestParam(defaultValue = "false") boolean actualizarEstadoCivil,
            @RequestParam(defaultValue = "false") boolean actualizarLugarNacimiento) {

        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }

        Optional<Person> personOptional = personaService.update(id, person, actualizarNombre, actualizarTelefono,
                actualizarFechaNacimiento, actualizarGenero, actualizarEstadoCivil, actualizarLugarNacimiento);

        if (personOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(personOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Person> personOptional = personaService.delete(id);

        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Person> personOptional = personaService.findById(id);

        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}
