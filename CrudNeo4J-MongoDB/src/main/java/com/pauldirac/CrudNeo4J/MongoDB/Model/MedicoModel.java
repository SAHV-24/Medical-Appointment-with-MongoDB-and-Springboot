package com.pauldirac.CrudNeo4J.MongoDB.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Medicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicoModel {

    @Id
    private String id;
    private Long cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private String estado;
    private String especialidad;

}