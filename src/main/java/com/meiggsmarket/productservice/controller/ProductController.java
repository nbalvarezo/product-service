package com.meiggsmarket.productservice.controller;

// Importa las clases necesarias
import com.meiggsmarket.productservice.dto.ProductResponse;
import com.meiggsmarket.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meiggsmarket.productservice.dto.ProductRequest;

import java.util.List;

// Anotación que indica que esta clase es un controlador REST
@RestController
// Anotación para definir la ruta base para este controlador
@RequestMapping("/api/product")
// Genera un constructor con parámetros para las dependencias requeridas
@RequiredArgsConstructor
public class ProductController {

	// Inyección de la dependencia del servicio de productos
	private final ProductService productService;

	// Maneja las solicitudes POST para crear un nuevo producto
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // Respuesta HTTP 201 CREATED
	public void createProduct(@RequestBody ProductRequest productRequest) {
		// Llama al servicio para crear el producto
		productService.createProduct(productRequest);
	}

	// Maneja las solicitudes GET para obtener todos los productos
	@GetMapping
	@ResponseStatus(HttpStatus.OK) // Respuesta HTTP 200 OK
	public List<ProductResponse> getAllProducts() {
		// Llama al servicio para obtener la lista de productos
		return productService.getAllProducts();
	}
}
