package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModelNeo;

import java.util.List;

public interface IUsuarioServiceNeo {

    String crearUsuario(UsuarioModelNeo usuario);

    UsuarioModelNeo obtenerUsuario(Long usuarioId);

    String eliminarUsuario(Long usuarioId);

    String actualizarUsuario(Long usuarioId, UsuarioModelNeo nuevoUsuario);

    List<UsuarioModelNeo> buscarPorRangoEdadYEps(int edadMinima, int edadMaxima, String eps);

    String actualizarPrioridadPacientesMayores();

    List<UsuarioModelNeo> buscarPorEpsMayores65(String eps);

}
