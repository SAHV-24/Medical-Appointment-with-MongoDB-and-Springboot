package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.CitaModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.ICitaRepositoryNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceNeo implements ICitaServiceNeo {

    private final ICitaRepositoryNeo repositoryNeo;

    @Autowired
    public CitaServiceNeo(ICitaRepositoryNeo repositoryNeo) {
        this.repositoryNeo = repositoryNeo;
    }

    public List<CitaModelNeo> obtenerTodas() {

        return repositoryNeo.findAll();

    }

    public Optional<CitaModelNeo> obtenerPorId(Long id) {

        return repositoryNeo.findById(id);

    }

    public CitaModelNeo guardar(CitaModelNeo cita) {

        return repositoryNeo.save(cita);

    }

    @Transactional
    public CitaModelNeo actualizar(Long id, CitaModelNeo cita) {

        CitaModelNeo citaRecuperada = repositoryNeo.findById(id).orElseThrow(() -> new RuntimeException(String.format("La cita con id \"%d\" no se encuentra en la base de datos", id)));

        citaRecuperada.setCitaId(cita.getCitaId());
        citaRecuperada.setConsultorio(cita.getConsultorio());
        citaRecuperada.setEstado(cita.getEstado());
        citaRecuperada.setPrioridad(cita.getPrioridad());
        citaRecuperada.setMedicoId(cita.getMedicoId());
        citaRecuperada.setFechaYHora(cita.getFechaYHora());
        citaRecuperada.setUsuarioId(cita.getUsuarioId());

        return repositoryNeo.save(citaRecuperada);

    }

    public void eliminar(Long id) {

        repositoryNeo.deleteById(id);

    }
}
