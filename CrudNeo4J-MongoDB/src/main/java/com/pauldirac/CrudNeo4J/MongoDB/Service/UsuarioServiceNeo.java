package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Exception.UsuarioNotFoundException;
import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.IUsuarioRepositoryNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceNeo implements IUsuarioServiceNeo {

    private final IUsuarioRepositoryNeo usuarioRepository;

    @Autowired
    public UsuarioServiceNeo(IUsuarioRepositoryNeo usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String crearUsuario(UsuarioModelNeo usuario) {

        try {

            UsuarioModelNeo nuevoUsuario = usuarioRepository.save(usuario);
            return "Usuario creado con éxito. ID: " + nuevoUsuario.getCedula();

        } catch (Exception e) {

            return "Error al crear el usuario: " + e.getMessage();

        }
    }


    public UsuarioModelNeo obtenerUsuario(Long usuarioId) {
        try {
            UsuarioModelNeo usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));
            return usuario;
        } catch (Exception e) {
            throw new UsuarioNotFoundException(
                    "El usuario con ID: " + usuarioId + " no fue encontrado en la base de datos.");
        }
    }

    public String eliminarUsuario(Long usuarioId) {
        try {
            usuarioRepository.deleteById(usuarioId);
            return "Usuario eliminado con éxito. ID: " + usuarioId;
        } catch (Exception e) {
            return "Error al eliminar el usuario: " + e.getMessage();
        }
    }


    public String actualizarUsuario(Long usuarioId, UsuarioModelNeo nuevoUsuario) {
        try {
            UsuarioModelNeo usuarioExistente = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));

            usuarioExistente.setApellido(nuevoUsuario.getApellido());
            usuarioExistente.setNombre(nuevoUsuario.getNombre());
            usuarioExistente.setCondicionesEspeciales(nuevoUsuario.getCondicionesEspeciales());
            usuarioExistente.setCedula(nuevoUsuario.getCedula());
            usuarioExistente.setCorreo(nuevoUsuario.getCorreo());
            usuarioExistente.setEdad(usuarioExistente.getEdad());
            usuarioExistente.setEps(nuevoUsuario.getEps());
            usuarioExistente.setTelefono(nuevoUsuario.getTelefono());
            usuarioExistente.setCitasRecibidas(nuevoUsuario.getCitasRecibidas());
            usuarioExistente.setPrioridad(nuevoUsuario.getPrioridad());

            usuarioRepository.save(usuarioExistente);

            return "Usuario actualizado con éxito. ID: " + usuarioId;
        } catch (Exception e) {
            return "Error al actualizar el usuario: " + e.getMessage();
        }
    }

    public List<UsuarioModelNeo> buscarPorEpsMayores65(String eps) {
        return usuarioRepository.findByEdadGreaterThanAndEps(65, eps).orElseThrow(() -> new RuntimeException("No se encontraron pacientes con esos criterios"));
    }

    public List<UsuarioModelNeo> buscarPorRangoEdadYEps(int edadMinima, int edadMaxima, String eps) {
        List<UsuarioModelNeo> usuarios = usuarioRepository.findUsuarioModelNeoByEdadBetweenAndEps(edadMinima, edadMaxima, eps).orElseThrow(() -> new RuntimeException("No se encontraron resultados"));
        return usuarios;
    }

    public String actualizarPrioridadPacientesMayores() {
        List<UsuarioModelNeo> pacientes = usuarioRepository.cambiarPrioridadCita().orElseThrow(() -> new RuntimeException("No se encontraron pacientes"));

        List<String> resultados = new ArrayList<>();
        for (UsuarioModelNeo usuario : pacientes) {
            if (!usuario.getPrioridad().equals("Alta")) {
                usuario.setPrioridad("Alta");
                usuarioRepository.save(usuario);
                resultados.add(usuario.getNombre());
            }
        }

        return !resultados.isEmpty() ? "Los usuarios que fueron actualizados fueron: \n " + resultados.toString()
                : "Ningún usuario fue actualizado";
    }

}
