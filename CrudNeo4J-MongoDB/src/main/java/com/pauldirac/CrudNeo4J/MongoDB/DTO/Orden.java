package com.pauldirac.CrudNeo4J.MongoDB.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orden {
    private String titulo;
    private LocalDate fechaExpiracion;
}
