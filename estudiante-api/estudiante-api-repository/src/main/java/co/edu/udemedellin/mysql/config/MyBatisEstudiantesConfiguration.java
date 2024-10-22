package co.edu.udemedellin.mysql.config;
import co.edu.udemedellin.IDSConfig;
import co.edu.udemedellin.mysql.EstudiantesRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackageClasses = EstudiantesRepository.class, sqlSessionFactoryRef = "jdbcServEstudiantesSessionFactory")
public class MyBatisEstudiantesConfiguration implements IDSConfig {

    // Propiedades para MySQL
    public static final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";  // Driver MySQL
    public static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/crud"; // URL de conexión MySQL
    public static final String DATASOURCE_USER_NAME = "apre_ti_01"; // Nombre de usuario de la base de datos
    public static final String DATASOURCE_PASSWORD = "abc12345#"; // Contraseña de la base de datos
    public static final String DATASOURCE_JDNI = "jdbc/crud"; // JNDI no cambia

    @Autowired
    private Environment environment;

    public MyBatisEstudiantesConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public SqlSessionFactory jdbcServEstudiantesSessionFactory(@Qualifier("EstudiantesDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(
                new ClassPathResource("mappers/estudiantes/estudiantes-mapper.xml")
        );
        return sqlSessionFactory.getObject();
    }

    @Bean(destroyMethod = "")
    public DataSource EstudiantesDatasource() {
        return getDs(environment,
                DATASOURCE_USER_NAME,
                DATASOURCE_PASSWORD,
                DATASOURCE_DRIVER,
                DATASOURCE_URL,
                DATASOURCE_JDNI
        );
    }
}
