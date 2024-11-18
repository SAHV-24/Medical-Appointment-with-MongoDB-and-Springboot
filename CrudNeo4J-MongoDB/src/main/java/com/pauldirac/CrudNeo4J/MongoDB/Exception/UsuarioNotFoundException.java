package com.pauldirac.CrudNeo4J.MongoDB.Exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
