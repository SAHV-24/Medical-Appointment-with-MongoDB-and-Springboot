package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModel;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Override
    public List<MedicoModel> obtenerTodos() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<MedicoModel> obtenerPorId(String id) {
        return medicoRepository.findById(id);
    }

    @Override
    public Optional<MedicoModel> obtenerPorCedula(Long cedula) {
        return medicoRepository.findByCedula(cedula);
    }

    @Override
    public MedicoModel guardar(MedicoModel medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void eliminar(String id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public Optional<MedicoModel> actualizar(String id, MedicoModel medico) {
        return medicoRepository.findById(id)
                .map(medicoExistente -> {
                    medico.setId(id);
                    return medicoRepository.save(medico);
                });
    }
}