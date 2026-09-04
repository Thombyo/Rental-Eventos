package com.senai.infoa.rental.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title="rental-eventos-api",
        version="1.0",
        description = "Feito por: Thomas Bayão."
    )
)

public class Swagger {
    
}
