package co.edu.udemedellin;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class Controller {
    final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<EstudianteDto>> getAllEstudiantesOrFinId(@RequestParam(required = false)Long estudianteId){
        return new ResponseEntity<>(service.getEstudiantesOrFinId(estudianteId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<EstudianteDto>> saveEstudiantes(@RequestBody List<EstudianteDto> Estudiantes) {
        return new ResponseEntity<>(Estudiantes, HttpStatus.OK);
    }


    @DeleteMapping("/estudianteId")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long estudianteId) {
        service.delete(estudianteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/estudianteId")
    public ResponseEntity<List<EstudianteDto>> updateEstudiantes(@PathVariable Long estudianteId) {
        List<EstudianteDto> Estudiantes = service.getEstudiantesOrFinId(estudianteId);
        return new ResponseEntity<>(Estudiantes, HttpStatus.OK);
    }


}
