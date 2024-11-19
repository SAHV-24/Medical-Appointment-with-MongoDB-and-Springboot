package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModel;
import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<MedicoModel> obtenerTodos();
    Optional<MedicoModel> obtenerPorId(String id);
    Optional<MedicoModel> obtenerPorCedula(Long cedula);
    MedicoModel guardar(MedicoModel medico);
    void eliminar(String id);
    Optional<MedicoModel> actualizar(String id, MedicoModel medico);
}