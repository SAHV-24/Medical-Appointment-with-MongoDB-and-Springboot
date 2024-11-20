package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModelNeo;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IMedicoRepositoryNeo extends Neo4jRepository<MedicoModelNeo, Long> {
}
