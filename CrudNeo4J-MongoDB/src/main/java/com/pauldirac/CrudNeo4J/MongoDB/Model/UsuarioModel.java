package com.pauldirac.CrudNeo4J.MongoDB.Model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioModel {
    @Id
    private String id;

    private Long cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String eps;
    private List<String> condicionesEspeciales;
}
