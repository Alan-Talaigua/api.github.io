package co.edu.udemedellin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import java.nio.file.Paths;
import java.util.Properties;
@SpringBootApplication
public class EstudianteApi extends SpringBootServletInitializer implements WebApplicationInitializer {
public static void main(String[] args) {
     new SpringApplicationBuilder(EstudianteApi.class)
         .sources( EstudianteApi.class)
         .properties(getProperties())
         .run(args);
    }
    @Override // sobreescribe un metodo de la base
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
       return builder.sources(EstudianteApi.class).properties(getProperties());
}
    static Properties getProperties() { //es un metodo que obtiene metodos para la configuracion de la aplicacion
        String path = Paths.get(System.getProperty("FOLDER_LOCATION"), "API_ESTUD", "application.yml").toAbsolutePath().normalize().toString();
        Properties prop = new Properties(); //establece la configuracioin del archivo de las propiedades
        prop.put("spring.config.location", path);
        return prop;// nos devuelve las propiedades configuaradas
     }
}