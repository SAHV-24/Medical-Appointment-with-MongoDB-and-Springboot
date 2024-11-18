package com.pauldirac.CrudNeo4J.MongoDB.Model;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioModel {
    @Id
    private ObjectId _id;

    @JsonProperty("_id")
    public String getIdAsString() {
        return _id != null ? _id.toHexString() : "";
    }

    private Long cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String eps;
    private List<String> condicionesEspeciales;
}
