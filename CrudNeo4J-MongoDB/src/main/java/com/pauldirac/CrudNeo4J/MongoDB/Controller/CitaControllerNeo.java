package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Service.ICitaServiceNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Citas/neo/")
public class CitaControllerNeo {

    private final ICitaServiceNeo citaService;

    @Autowired
    public CitaControllerNeo(ICitaServiceNeo citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaModelNeo> obtenerPorId(@PathVariable Long id) {

        return citaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping("/insertar")
    public ResponseEntity<CitaModelNeo> crear(@RequestBody CitaModelNeo cita) {
        return new ResponseEntity<>(citaService.guardar(cita), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CitaModelNeo cita) {

        try {

            return new ResponseEntity<>(citaService.actualizar(id, cita), HttpStatus.OK);

        }
        catch(RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }


    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
