package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModelNeo;

import java.util.List;
import java.util.Optional;

public interface IMedicoServiceNeo {

    List<MedicoModelNeo> obtenerTodos();
    Optional<MedicoModelNeo> obtenerPorCedula(Long cedula);
    MedicoModelNeo guardar(MedicoModelNeo medico);
    void eliminar(Long id);
    MedicoModelNeo actualizar(Long id, MedicoModelNeo medico);

}
