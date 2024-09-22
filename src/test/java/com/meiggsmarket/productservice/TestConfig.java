package com.meiggsmarket.productservice;

// Importa las clases necesarias
import org.springframework.context.annotation.Bean;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

// Clase de configuración para pruebas
public class TestConfig {
    // Método que define un bean de ObjectMapper para la serialización/deserialización de JSON
    @Bean
    public ObjectMapper objectMapper() {
        // Retorna una nueva instancia de ObjectMapper
        return new ObjectMapper();
    }
}
