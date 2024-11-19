package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICitaRepository extends MongoRepository<CitaModel, ObjectId> {
    Optional<CitaModel> findByCitaId(Long citaId);
    List<CitaModel> findByMedicoId(Long medicoId);
    List<CitaModel> findByUsuarioId(Long usuarioId);
    List<CitaModel> findByFechaYHoraBetween(Date inicio, Date fin);
    List<CitaModel> findByEstado(String estado);
}
