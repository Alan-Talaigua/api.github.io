package co.edu.udemedellin;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Arrays;
public interface IDSConfig {
    default DataSource getDs(Environment envs, String username, String password, String driverClassName, String url, String jndi) {
        if (Arrays.asList(envs.getActiveProfiles()).contains("dev")) {            // Para entorno de desarrollo, se usa el DataSource directo
           return DataSourceBuilder.create()
                   .username(username)         // Usuario de la base de datos
                   .password(password)         // Contraseña de la base de datos
                   .driverClassName(driverClassName) // Controlador para MySQL, usualmente "com.mysql.cj.jdbc.Driver"
                   .url(url)                   // URL de la base de datos (jdbc:mysql://localhost:3306/nombreBD)
                   .build();
        } else if (Arrays.asList(envs.getActiveProfiles()).contains("pru")) {            // Para entorno de pruebas, se usa JNDI
           JndiTemplate jndiTemplate = new JndiTemplate();
           try {
               DataSource dataSource = (DataSource) jndiTemplate.lookup(jndi + "_pru");
               return dataSource;
           }
           catch (NamingException e) {
               throw new IllegalArgumentException("Error al conectarse al DataSource via JNDI", e);
           }
        } else {            // Para otros entornos, también se usa JNDI
             JndiTemplate jndiTemplate = new JndiTemplate();
             try {                DataSource dataSource = (DataSource) jndiTemplate.lookup(jndi);
                 return dataSource;
             }
             catch (NamingException e) {
                 throw new IllegalArgumentException("Error al conectarse al DataSource via JNDI", e);
             }
        }
    }
}