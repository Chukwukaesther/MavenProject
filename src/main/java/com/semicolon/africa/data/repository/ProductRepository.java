package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, Long> {
}
