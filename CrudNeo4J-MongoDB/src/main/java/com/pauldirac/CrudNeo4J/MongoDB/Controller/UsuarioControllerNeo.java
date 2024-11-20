package com.pauldirac.CrudNeo4J.MongoDB.Controller;

import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Service.IUsuarioServiceNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios/neo")
public class UsuarioControllerNeo {

    private final IUsuarioServiceNeo usuarioService;

    @Autowired
    public UsuarioControllerNeo(IUsuarioServiceNeo usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<UsuarioModelNeo>> obtenerTodosUsuarios() {

        return new ResponseEntity<>(usuarioService.obtenerTodos(), HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioModelNeo usuario) {

        String resultado = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(resultado);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModelNeo> obtenerUsuario(@PathVariable("id") Long id) {

        UsuarioModelNeo usuario = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(usuario);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("id") Long id) {

        String resultado = usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(resultado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable("id") Long id,
                                                    @RequestBody UsuarioModelNeo nuevoUsuario) {

        String resultado = usuarioService.actualizarUsuario(id, nuevoUsuario);
        return ResponseEntity.ok(resultado);

    }

    @GetMapping("/mayores/{eps}")
    public ResponseEntity<List<UsuarioModelNeo>> buscarPorEpsMayores65(@PathVariable("eps") String eps) {

        List<UsuarioModelNeo> usuarios = usuarioService.buscarPorEpsMayores65(eps);
        return ResponseEntity.ok(usuarios);

    }

    @GetMapping("/rango-edad/{edadMinima}/{edadMaxima}/{eps}")
    public ResponseEntity<List<UsuarioModelNeo>> buscarPorRangoEdadYEps(@PathVariable("edadMinima") int edadMinima,
                                                                     @PathVariable("edadMaxima") int edadMaxima,
                                                                     @PathVariable("eps") String eps) {
        List<UsuarioModelNeo> usuarios = usuarioService.buscarPorRangoEdadYEps(edadMinima, edadMaxima, eps);
        return ResponseEntity.ok(usuarios);

    }

    @PutMapping("/prioridad")
    public ResponseEntity<String> actualizarPrioridadPacientesMayores() {

        return ResponseEntity.ok(usuarioService.actualizarPrioridadPacientesMayores());

    }

}
