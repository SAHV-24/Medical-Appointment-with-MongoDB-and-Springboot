package com.pauldirac.CrudNeo4J.MongoDB.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Node("Cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaModelNeo {

    @Id
    private Long citaId;

    private Long usuarioId;
    private Long medicoId;

    private String prioridad;
    private Date fechaYHora;
    private String consultorio;
    private String estado;

    @Relationship(type = "Tiene", direction = Relationship.Direction.INCOMING)
    private UsuarioModelNeo usuario;

    @Relationship(type = "Atiende", direction = Relationship.Direction.OUTGOING)
    private MedicoModelNeo doctor;

}



