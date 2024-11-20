package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


public interface ICitaService {
    List<CitaModel> obtenerTodas();
    Optional<CitaModel> obtenerPorId(ObjectId id);
    CitaModel guardar(CitaModel cita);
    Optional<CitaModel> actualizar(ObjectId id, CitaModel cita);
    void eliminar(ObjectId id);
}