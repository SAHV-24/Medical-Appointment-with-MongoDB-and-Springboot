package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import Enum.Estado;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection="Citas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CitasModel {
    @Id
    private Long citaId;
    private Long medicoId;
    private Date fechaYHora;
    private String consultorio;
    private Estado estado;
    private Ordenes ordenes;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Ordenes{
        private String titulo;
        private Date fechaExpiracion;
        private List<String> medicamentos;
     }

}
