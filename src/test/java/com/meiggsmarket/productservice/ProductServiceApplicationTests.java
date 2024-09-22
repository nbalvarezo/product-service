package com.meiggsmarket.productservice;

import com.meiggsmarket.productservice.dto.ProductRequest;
import com.meiggsmarket.productservice.model.Product;
import com.meiggsmarket.productservice.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.Duration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@Import(TestConfig.class)
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2")
			.withExposedPorts(27017)
			.withStartupTimeout(Duration.ofMinutes(2));

	@DynamicPropertySource
	static void setProperties(@NotNull DynamicPropertyRegistry dynamicPropertyRegistry) {
		String mongoUri = mongoDBContainer.getReplicaSetUrl();
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", () -> mongoUri);
	}

	@BeforeEach
	void cleanRegistry() {
		productRepository.deleteAll(); // Limpia la colección de productos
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());

		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	@Test
	void testFindAll() {
		Product product = new Product();
		product.setName("Product 1");
		product.setPrice(BigDecimal.valueOf(9.99));
		productRepository.save(product);

		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("IPhone 13")
				.description("IPhone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
	}
}
