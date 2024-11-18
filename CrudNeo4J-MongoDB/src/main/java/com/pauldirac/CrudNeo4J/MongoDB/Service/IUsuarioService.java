package com.pauldirac.CrudNeo4J.MongoDB.Service;

import org.bson.types.ObjectId;

import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModel;

public interface IUsuarioService {

    String crearUsuario(UsuarioModel usuario);

    UsuarioModel obtenerUsuario(ObjectId usuarioId);

    String eliminarUsuario(ObjectId usuarioId);

    String actualizarUsuario(ObjectId usuarioId, UsuarioModel nuevoUsuario);

}
