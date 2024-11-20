package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModelNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepositoryNeo extends Neo4jRepository<UsuarioModelNeo, Long> {

    Optional<List<UsuarioModelNeo>> findUsuarioModelNeoByEdadBetweenAndEps(Integer min, Integer max, String eps);

    @Query("MATCH (u:Usuario)-[:Tiene]->(c:Cita) " +
            "WHERE u.edad > 65 AND any(condicion IN u.condicionesEspeciales WHERE toLower(condicion) IN ['hipertensión', 'diabetes', 'cáncer']) " +
            "SET c.prioridad = 'Alta'")
    void cambiarPrioridadCita();

    Optional<List<UsuarioModelNeo>> findByEdadGreaterThanAndEps(Integer edad, String eps);

}
