package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;

public interface CitaRepository extends Neo4jRepository<CitaModel, Long> {
    
}
