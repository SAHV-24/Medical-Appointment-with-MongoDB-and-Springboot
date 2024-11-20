package com.pauldirac.CrudNeo4J.MongoDB.Model;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node("Doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoModelNeo {

    @Id
    private Long cedula;

    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private String estado;
    private String especialidad;

    @Relationship(type = "Atiende", direction = Relationship.Direction.INCOMING)
    private Set<CitaModelNeo> citasAtendidas;

}
