package com.meiggsmarket.productservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
@Data
@Builder
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
	
}


