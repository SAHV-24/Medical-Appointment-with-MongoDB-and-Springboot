package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Service.IMedicoServiceNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Medicos/neo")
public class MedicoControllerNeo {

    private final IMedicoServiceNeo medicoService;

    @Autowired
    public MedicoControllerNeo(IMedicoServiceNeo medicoService) {

        this.medicoService = medicoService;

    }

    @GetMapping
    public ResponseEntity<List<MedicoModelNeo>> obtenerTodos() {

        return ResponseEntity.ok(medicoService.obtenerTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoModelNeo> obtenerPorId(@PathVariable Long id) {

        return medicoService.obtenerPorCedula(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping("/insertar")
    public ResponseEntity<MedicoModelNeo> crear(@RequestBody MedicoModelNeo medico) {

        return ResponseEntity.ok(medicoService.guardar(medico));

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MedicoModelNeo> actualizar(@PathVariable Long id, @RequestBody MedicoModelNeo medico) {

        return new ResponseEntity<>(medicoService.actualizar(id, medico), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();

    }

}
