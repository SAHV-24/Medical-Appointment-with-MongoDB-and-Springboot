package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "Medicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicosModel {
    @Id
    private Double cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;

    private Especialidad especialidad;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Especialidad{
        private String nombre;
        private Boolean estaVigente;
    }

}
