package com.pauldirac.CrudNeo4J.MongoDB.Model;

import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModelNeo {

    @Id
    private Long cedula;

    private String prioridad;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private Integer edad;
    private String eps;
    private List<String> condicionesEspeciales;

    @Relationship(type = "Tiene", direction = Relationship.Direction.OUTGOING)
    private Set<CitaModelNeo> citasRecibidas;

}
