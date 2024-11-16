package com.pauldirac.CrudNeo4J.MongoDB.Model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.pauldirac.CrudNeo4J.MongoDB.DTO.Orden;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Node("Cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaModel {

    @Id
    @GeneratedValue 
    private Long citaId;

    private String prioridad;
    private LocalDateTime fechaYHora;
    private String consultorio;
    private String estado;
    private List<Orden> ordenes;

}

    