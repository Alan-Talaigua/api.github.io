package co.edu.udemedellin;

import java.util.List;

public interface Service {
    void delete(Long estudianteId);
    List<EstudianteDto> getEstudiantesOrFinId(Long estudianteId);
}