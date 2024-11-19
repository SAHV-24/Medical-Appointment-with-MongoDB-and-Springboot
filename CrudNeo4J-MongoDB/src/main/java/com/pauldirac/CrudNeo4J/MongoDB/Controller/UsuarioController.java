package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModel;
import com.pauldirac.CrudNeo4J.MongoDB.Service.IUsuarioService;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioModel usuario) {
        String resultado = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(resultado);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuario(@PathVariable("id") ObjectId id) {
        UsuarioModel usuario = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("id") ObjectId id) {
        String resultado = usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(resultado);
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(
            @PathVariable("id") ObjectId id,
            @RequestBody UsuarioModel nuevoUsuario) {
        String resultado = usuarioService.actualizarUsuario(id, nuevoUsuario);
        return ResponseEntity.ok(resultado);
    }

    // Buscar usuarios mayores de 65 años por EPS
    @GetMapping("/mayores/{eps}")
    public ResponseEntity<List<UsuarioModel>> buscarPorEpsMayores65(@PathVariable("eps") String eps) {
        List<UsuarioModel> usuarios = usuarioService.buscarPorEpsMayores65(eps);
        return ResponseEntity.ok(usuarios);
    }

    // Buscar usuarios por rango de edad y EPS
    @GetMapping("/rango-edad/{edadMinima}/{edadMaxima}/{eps}")
    public ResponseEntity<List<UsuarioModel>> buscarPorRangoEdadYEps(
            @PathVariable("edadMinima") int edadMinima,
            @PathVariable("edadMaxima") int edadMaxima,
            @PathVariable("eps") String eps) {
        List<UsuarioModel> usuarios = usuarioService.buscarPorRangoEdadYEps(edadMinima, edadMaxima, eps);
        return ResponseEntity.ok(usuarios);
    }

    // Actualizar prioridad de pacientes mayores con condiciones especiales
    @PutMapping("/prioridad")
    public ResponseEntity<String> actualizarPrioridadPacientesMayores(@RequestBody List<String> condicionesEspeciales) {
        
        return ResponseEntity.ok(usuarioService.actualizarPrioridadPacientesMayores(condicionesEspeciales));
    }

}
