package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModel;

public interface IMedicoRepository extends MongoRepository<MedicoModel, String> {

}
