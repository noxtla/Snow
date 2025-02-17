package com.noxtla.snow.crud.controllers;



public class readMe {
    /*
    Nos falta terminar persona
    estamos en la rama de genre-person
    */

    ///TODO
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


