package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModel;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.ICitaRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements ICitaService {

    @Autowired
    private ICitaRepository citaRepository;

    @Override
    public List<CitaModel> obtenerTodas() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<CitaModel> obtenerPorId(ObjectId id) {
        return citaRepository.findById(id);
    }

  
    @Override
    public CitaModel guardar(CitaModel cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Optional<CitaModel> actualizar(ObjectId id, CitaModel cita) {
        return citaRepository.findById(id)
            .map(citaExistente -> {
                cita.set_id(id);
                return citaRepository.save(cita);
            });
    }

    @Override
    public void eliminar(ObjectId id) {
        citaRepository.deleteById(id);
    }
}