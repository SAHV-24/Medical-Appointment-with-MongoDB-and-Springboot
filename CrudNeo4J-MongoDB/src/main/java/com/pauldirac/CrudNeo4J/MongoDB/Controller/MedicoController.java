package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModel;
import com.pauldirac.CrudNeo4J.MongoDB.Service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Medicos")
public class MedicoController {

    @Autowired
    private IMedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoModel>> obtenerTodos() {
        return ResponseEntity.ok(medicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoModel> obtenerPorId(@PathVariable String id) {
        return medicoService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

 
    @PostMapping("/insertar")
    public ResponseEntity<MedicoModel> crear(@RequestBody MedicoModel medico) {
        return ResponseEntity.ok(medicoService.guardar(medico));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MedicoModel> actualizar(@PathVariable String id, @RequestBody MedicoModel medico) {
        return medicoService.actualizar(id, medico)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}