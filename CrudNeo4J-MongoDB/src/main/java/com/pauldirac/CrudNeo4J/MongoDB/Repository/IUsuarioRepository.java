package com.pauldirac.CrudNeo4J.MongoDB.Repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.pauldirac.CrudNeo4J.MongoDB.Model.UsuarioModel;

public interface IUsuarioRepository extends MongoRepository<UsuarioModel, ObjectId> {

       // 1. Consulta por rango de edad y EPS mejorada
       @Query("{ $and:[ {eps: \"?2\"  }, {edad: {$gte: ?0} },{edad:{$lte:?1}}]}")
       List<UsuarioModel> findByRangoEdadAndEps(int edadMinima, int edadMaxima, String eps);

       // 2. Consulta para pacientes mayores con condiciones especiales mejorada
       @Query("{ '$and': [ " +
                     "  { 'condicionesEspeciales': { '$in': ?0 } }, " + "{'edad':{$gte:65}}" +
                     "]}")
       List<UsuarioModel> findPacientesMayoresConCondiciones(List<String> condiciones);

       // 3. Consulta por EPS y mayores de 65 años corregida
       @Query("{'edad': {'$gte': 65}, 'eps': ?0}")
       List<UsuarioModel> findByEpsAndMayores65(String eps);
}