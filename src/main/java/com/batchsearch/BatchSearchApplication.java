package com.batchsearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.core", "com.batchsearch"})
@OpenAPIDefinition(info = @Info(
        title = "POC Modulos",
        version = "alpha",
        description = "Projeto de prova de conceito."
))
public class BatchSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchSearchApplication.class, args);
    }
}
