package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosModel {
    @Id
    private Double cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String correo;
    private Date fechaNacimiento;

}
