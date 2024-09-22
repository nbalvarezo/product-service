package com.meiggsmarket.productservice.service;

// Importa las clases necesarias
import com.meiggsmarket.productservice.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.meiggsmarket.productservice.dto.ProductRequest;
import com.meiggsmarket.productservice.model.Product;
import com.meiggsmarket.productservice.repository.ProductRepository;

// Importaciones de Spring para la gestión de controladores
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

// Indica que esta clase es un servicio de Spring
@Service
// Habilita el registro (logging) para esta clase
@Slf4j
// Genera un constructor con parámetros para las dependencias requeridas
@RequiredArgsConstructor
public class ProductService {

	// Repositorio para acceder a los productos en la base de datos
	private final ProductRepository productRepository;

	// Método para crear un nuevo producto
	public void createProduct(ProductRequest productRequest) {
		// Crea un nuevo objeto Product utilizando el builder
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();

		// Guarda el producto en el repositorio
		productRepository.save(product);
		// Registra información sobre el producto guardado
		log.info("Product {} is save.", product.getId());
	}

	// Mapea las solicitudes GET para obtener todos los productos
	@GetMapping
	@ResponseStatus(HttpStatus.OK) // Respuesta HTTP 200 OK
	public List<ProductResponse> getAllProducts(){
		// Recupera todos los productos del repositorio
		List<Product> products = productRepository.findAll();
		// Convierte la lista de productos en una lista de ProductResponse
		return products.stream().map(this::mapToProductResponse).toList();
	}

	// Método privado para mapear un objeto Product a ProductResponse
	private ProductResponse mapToProductResponse(Product product) {
		// Crea y devuelve un ProductResponse utilizando el builder
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}
