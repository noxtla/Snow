package com.noxtla.snow.crud.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.noxtla.snow.crud.models.BirthPlace;
import com.noxtla.snow.crud.services.Interfaces.IBirthPlaceService;
import com.noxtla.snow.crud.utils.ValidationUtils;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/birthPlace")
public class BirthPlaceController {

    @Autowired
    IBirthPlaceService birthPlaceService;

    @Autowired
    private ValidationUtils validationUtils;


    @GetMapping("/listAll")
    public List<BirthPlace> listLugarNacimiento() {
        return birthPlaceService.findAll();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody BirthPlace lugarNacimiento, BindingResult result,
            @PathVariable Long id,
            @RequestParam(defaultValue = "false") boolean actualizarCiudad,
            @RequestParam(defaultValue = "false") boolean actualizarEstado,
            @RequestParam(defaultValue = "false") boolean actualizarPais) {

        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }

        Optional<BirthPlace> lugarNacimientoOptional = birthPlaceService.update(id, lugarNacimiento,
                actualizarCiudad, actualizarEstado, actualizarPais);

        if (lugarNacimientoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(lugarNacimientoOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id){

        Optional<BirthPlace> lugarNacimienOptional = birthPlaceService.findById(id);
        if(lugarNacimienOptional.isPresent()){
            return ResponseEntity.ok(lugarNacimienOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody BirthPlace lugarNacimiento, BindingResult result) {

        System.out.println("Recibido: " + lugarNacimiento.getCity() + ", " + lugarNacimiento.getState() + ", " + lugarNacimiento.getCountry());

        if (result.hasFieldErrors()) {
            return validationUtils.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(birthPlaceService.save(lugarNacimiento));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<BirthPlace> lugarNacimientoOptional = birthPlaceService.delete(id);

        if (lugarNacimientoOptional.isPresent()) {
            return ResponseEntity.ok(lugarNacimientoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


}
