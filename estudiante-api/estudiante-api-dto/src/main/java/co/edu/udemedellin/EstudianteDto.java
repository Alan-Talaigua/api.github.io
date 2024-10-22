package co.edu.udemedellin;
import lombok.Data;
@Data
public class EstudianteDto {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String edad;
}