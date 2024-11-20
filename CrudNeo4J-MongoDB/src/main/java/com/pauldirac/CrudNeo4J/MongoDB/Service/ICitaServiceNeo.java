package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModelNeo;


import java.util.List;
import java.util.Optional;

public interface ICitaServiceNeo {

    List<CitaModelNeo> obtenerTodas();
    Optional<CitaModelNeo> obtenerPorId(Long id);
    CitaModelNeo guardar(CitaModelNeo cita);
    CitaModelNeo actualizar(Long id, CitaModelNeo cita);
    void eliminar(Long id);

}
