package my.solution.project3.lesson4.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
// only by version < 3.0.0
// http://localhost:8311/swagger-ui.html
//@EnableSwagger2

// only by version > 3.0.0
// http://localhost:8211/swagger-ui/
//@EnableSwagger2WebMvc

public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog API",
                "This API returns a list of dogs.",
                "1.0",
                "http://url.de/tos",
                new Contact("Roberto de Freitas", "my.url.com", "my@email.com"),
                "License of API", "http://url.de/license", Collections.emptyList());
    }
}