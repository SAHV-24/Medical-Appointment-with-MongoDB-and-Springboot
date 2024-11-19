package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;
import com.pauldirac.CrudNeo4J.MongoDB.Service.ICitaService;

@RestController
@RequestMapping("/api/Citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @GetMapping("/")
    public ResponseEntity<List<CitaModel>> obtenerTodas() {
        return ResponseEntity.ok(citaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaModel> obtenerPorId(@PathVariable ObjectId id) {
        return citaService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/insertar")
    public ResponseEntity<CitaModel> crear(@RequestBody CitaModel cita) {
        return new ResponseEntity<>(citaService.guardar(cita), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CitaModel> actualizar(@PathVariable ObjectId id, @RequestBody CitaModel cita) {
        return citaService.actualizar(id, cita)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ObjectId id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}