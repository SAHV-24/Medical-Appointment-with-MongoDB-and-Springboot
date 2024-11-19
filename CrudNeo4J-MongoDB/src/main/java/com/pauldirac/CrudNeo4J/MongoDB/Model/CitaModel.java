package com.pauldirac.CrudNeo4J.MongoDB.Model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Document(collection = "Citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaModel {

    @Id
    private ObjectId _id;    

    private String prioridad;    
    private Long citaId;    
    private Long usuarioId;    
    private Long medicoId;    

  
    private Date fechaYHora;    
    
    private String consultorio;    
    private String estado;

}
    