package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModelNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ICitaRepositoryNeo extends Neo4jRepository<CitaModelNeo, String> {
}
