package com.meiggsmarket.productservice;

// Importa las clases necesarias de Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que marca esta clase como la clase principal de una aplicación Spring Boot
@SpringBootApplication
public class ProductServiceApplication {
	// Método principal que se ejecuta al iniciar la aplicación
	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
