package com.pauldirac.CrudNeo4J.MongoDB.Service;

import com.pauldirac.CrudNeo4J.MongoDB.Model.MedicoModelNeo;
import com.pauldirac.CrudNeo4J.MongoDB.Repository.IMedicoRepositoryNeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.*;

@Service
public class MedicoServiceNeo implements IMedicoServiceNeo {

    private final IMedicoRepositoryNeo medicoRepository;

    @Autowired
    public MedicoServiceNeo(IMedicoRepositoryNeo medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<MedicoModelNeo> obtenerTodos() {

        return medicoRepository.findAll();

    }

    public Optional<MedicoModelNeo> obtenerPorCedula(Long cedula) {

        return medicoRepository.findById(cedula);

    }

    public MedicoModelNeo guardar(MedicoModelNeo medico) {

        return medicoRepository.save(medico);

    }

    public void eliminar(Long id) {

        medicoRepository.deleteById(id);

    }

    public MedicoModelNeo actualizar(Long id, MedicoModelNeo medicoEntrante) {

        MedicoModelNeo medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException(format("No se encontró un médico con identificación \"%d\"", id)));

        medico.setNombre(medicoEntrante.getNombre());
        medico.setApellido(medicoEntrante.getApellido());
        medico.setCedula(medicoEntrante.getCedula());
        medico.setCorreo(medicoEntrante.getCorreo());
        medico.setTelefono(medicoEntrante.getTelefono());
        medico.setEstado(medicoEntrante.getEstado());
        medico.setEspecialidad(medicoEntrante.getEspecialidad());
        medico.setCitasAtendidas(medicoEntrante.getCitasAtendidas());

        return medicoRepository.save(medico);

    }

}
