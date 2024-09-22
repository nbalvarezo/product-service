package com.meiggsmarket.productservice.dto;

// Importa la clase BigDecimal para manejar valores monetarios
import java.math.BigDecimal;

// Importa las anotaciones de Lombok para la generación de código
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotación que genera getters, setters, toString, equals y hashCode
@Data
// Anotación para habilitar el patrón Builder
@Builder
// Anotación para generar un constructor con todos los parámetros
@AllArgsConstructor
// Anotación para generar un constructor sin parámetros
@NoArgsConstructor
public class ProductRequest {
	// Nombre del producto
	private String name;

	// Descripción del producto
	private String description;

	// Precio del producto, usando BigDecimal para manejar valores monetarios
	private BigDecimal price;
}
