package com.meiggsmarket.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.meiggsmarket.productservice.model.Product;

import java.util.Collection;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
