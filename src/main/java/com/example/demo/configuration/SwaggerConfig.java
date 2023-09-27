package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class for Swagger documentation.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * Configures and initializes Swagger for the Spring Boot application.
     *
     * @return A Docket instance that provides Swagger documentation.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")) // Scan for controllers in this package
                .paths(PathSelectors.any()) // Include all paths in the documentation
                .build();
    }
}
