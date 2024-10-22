package co.edu.udemedellin;
import co.edu.udemedellin.mysql.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImpl implements co.edu.udemedellin.Service{
    private EstudiantesRepository estudiantesRepository;
    @Autowired
    public void setEstudiantesRepository(EstudiantesRepository estudiantesRepository) {
        this.estudiantesRepository = estudiantesRepository;
    }

    @Override
    public List<EstudianteDto> getEstudiantesOrFinId(Long estudianteId) {
        return estudiantesRepository.getEstudiantesOrFinId(estudianteId);
    }

    @Override
    public void delete(Long estudianteId) {
        estudiantesRepository.delete(estudianteId);
    }
}