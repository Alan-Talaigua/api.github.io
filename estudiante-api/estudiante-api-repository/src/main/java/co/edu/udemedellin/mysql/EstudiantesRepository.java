package co.edu.udemedellin.mysql;
import co.edu.udemedellin.EstudianteDto;
import java.util.List;

public interface EstudiantesRepository {
    void delete(Long estudianteId);
    List<EstudianteDto> getEstudiantesOrFinId(Long estudianteId);
}