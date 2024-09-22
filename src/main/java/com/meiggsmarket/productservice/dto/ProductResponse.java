package com.meiggsmarket.productservice.dto;

// Importa las anotaciones de Lombok para la generación de código
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Anotación para generar un constructor con todos los parámetros
@AllArgsConstructor
// Anotación para generar un constructor sin parámetros
@NoArgsConstructor
// Anotación para habilitar el patrón Builder
@Builder
// Anotación que genera getters, setters, toString, equals y hashCode
@Data
public class ProductResponse {

    // ID del producto
    private String id;

    // Nombre del producto
    private String name;

    // Descripción del producto
    private String description;

    // Precio del producto, usando BigDecimal para manejar valores monetarios
    private BigDecimal price;
}
