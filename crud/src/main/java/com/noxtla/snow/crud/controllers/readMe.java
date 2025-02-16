package com.noxtla.snow.crud.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxtla.snow.crud.models.LugarNacimiento;

public class readMe {
    /*Recuerda documentar los EndPoisnta en yaml
    tienes el  openApi en desktop/Snow*/ 

    ///Ver el JSON crudo
    /* 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody String rawJson) {
        // 🛠️ Ver JSON sin procesar
        System.out.println("JSON recibido en crudo: " + rawJson);

        ObjectMapper objectMapper = new ObjectMapper();
        LugarNacimiento lugarNacimiento = null;

        try {
            lugarNacimiento = objectMapper.readValue(rawJson, LugarNacimiento.class);
            System.out.println("Ciudad: " + lugarNacimiento.getCiudad());
            System.out.println("Estado: " + lugarNacimiento.getEstado());
            System.out.println("Pais: " + lugarNacimiento.getPais());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al convertir JSON a objeto");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(lugarDeNacimientoService.save(lugarNacimiento));
    }*/

}


