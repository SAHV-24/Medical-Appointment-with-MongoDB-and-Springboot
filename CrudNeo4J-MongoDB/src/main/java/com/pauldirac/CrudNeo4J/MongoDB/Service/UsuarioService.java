package com.pauldirac.CrudNeo4J.MongoDB.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Exception.UsuarioNotFoundException;
import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;
import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModel;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
<<<<<<< HEAD

    @Autowired
    private ICitaService citaService;
=======
>>>>>>> 8bca4f7de4ff64c8dd41fedbb1fb1ccc0e05f564

    @Override
    public String crearUsuario(UsuarioModel usuario) {
        try {
            UsuarioModel nuevoUsuario = usuarioRepository.save(usuario);
            return "Usuario creado con éxito. ID: " + nuevoUsuario.getIdAsString();
        } catch (Exception e) {
            return "Error al crear el usuario: " + e.getMessage();
        }
    }

    @Override
    public UsuarioModel obtenerUsuario(ObjectId usuarioId) {
        try {
            UsuarioModel usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));
            return usuario;
        } catch (Exception e) {
            throw new UsuarioNotFoundException(
                    "El usuario con ID: " + usuarioId + " no fue encontrado en la base de datos.");
        }
    }

    @Override
    public String eliminarUsuario(ObjectId usuarioId) {
        try {
            usuarioRepository.deleteById(usuarioId);
            return "Usuario eliminado con éxito. ID: " + usuarioId;
        } catch (Exception e) {
            return "Error al eliminar el usuario: " + e.getMessage();
        }
    }

    @Override
    public String actualizarUsuario(ObjectId usuarioId, UsuarioModel nuevoUsuario) {
        try {
            UsuarioModel usuarioExistente = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));

            // Actualiza los campos del usuario
            usuarioExistente.setNombre(nuevoUsuario.getNombre());
            usuarioExistente.setApellido(nuevoUsuario.getApellido());
            usuarioExistente.setCedula(nuevoUsuario.getCedula());
            usuarioExistente.setCondicionesEspeciales(nuevoUsuario.getCondicionesEspeciales());
            usuarioExistente.setCorreo(nuevoUsuario.getCorreo());
            usuarioExistente.setEps(nuevoUsuario.getEps());
            usuarioExistente.setEdad(usuarioExistente.getEdad());
            usuarioExistente.setTelefono(nuevoUsuario.getTelefono());

            usuarioRepository.save(usuarioExistente);

            return "Usuario actualizado con éxito. ID: " + usuarioId;
        } catch (Exception e) {
            return "Error al actualizar el usuario: " + e.getMessage();
        }
    }

    @Override
    public List<UsuarioModel> buscarPorEpsMayores65(String eps) {
        return usuarioRepository.findByEpsAndMayores65(eps);
    }

    @Override
    public List<UsuarioModel> buscarPorRangoEdadYEps(int edadMinima, int edadMaxima, String eps) {
        List<UsuarioModel> usuarios = usuarioRepository.findByRangoEdadAndEps(edadMinima, edadMaxima, eps);
        return usuarios;
    }

    @Override
    public String actualizarPrioridadPacientesMayores(List<String> condicionesEspeciales) {

        List<UsuarioModel> pacientes = usuarioRepository.findPacientesMayoresConCondiciones(condicionesEspeciales);

        List<Map<String, String>> resultados = new ArrayList<>();
        for (UsuarioModel usuario : pacientes) {
            if (!usuario.getPrioridad().equals("Alta")) {
                usuario.setPrioridad("Alta");
                usuarioRepository.save(usuario);

                Map<String, String> obj = new HashMap<String, String>();

                obj.put("nombre", usuario.getNombre());
                obj.put("eps", usuario.getEps());

                resultados.add(obj);

                List<CitaModel> citasDelUsuario = citaService.obtenerPorUsuarioId(usuario.getCedula());

                for (CitaModel cita : citasDelUsuario) {

                    cita.setPrioridad("Alta");
                    citaService.actualizar(cita.get_id(), cita); // Actualiza todas las citas

                }

            }
        }

        String res = "";

        if (resultados.size() == 0)
            res = "Ningún usuario fue actualizado";
        else {

            for (Map<String, String> result : resultados) {

                res += "----------------------------------------------------------------------\n";
                res += "El usuario " + result.get("nombre") + " de la EPS: " + result.get("eps") +"\n"
                        + " fue modificado a ALTA prioridad.";
                res += "----------------------------------------------------------------------\n";

            }

        }

        return res;

    }
}
