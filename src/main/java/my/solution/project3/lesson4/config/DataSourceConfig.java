package my.solution.project3.lesson4.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * This configuration is deactivated.
 * I use only the file application.properties for the DB configuration
 * 13.01.2022
 */
@Configuration
public class DataSourceConfig {
    /**
     * ## Lesson4 Part 09
     * This configuration method needs following contents on the application.properties:
     * com.udacity.datasource.username=user-udacity
     * com.udacity.datasource.password=pw-udacity
     *
     * This method+application.properties works!
     */
/*
    @Bean
    @Primary
    @ConfigurationProperties(prefix="com.udacity.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        //dsb.url("jdbc:mysql://localhost:3306/plant");
        dsb.url("jdbc:postgresql://localhost:5411/udacity-p3-lesson-db");
        return dsb.build();
    }
*/
}
