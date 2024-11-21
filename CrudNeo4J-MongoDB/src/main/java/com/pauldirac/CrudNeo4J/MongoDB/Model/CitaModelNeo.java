package com.pauldirac.CrudNeo4J.MongoDB.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

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
    private ZonedDateTime fechaYHora;
    private String consultorio;
    private String estado;

}



