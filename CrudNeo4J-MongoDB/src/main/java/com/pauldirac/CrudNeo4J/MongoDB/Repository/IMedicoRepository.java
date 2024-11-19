package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModel;

public interface IMedicoRepository extends MongoRepository<MedicoModel, String> {
    Optional<MedicoModel> findByCedula(Long cedula);
}
