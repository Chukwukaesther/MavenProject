package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByEmail(String email);
    Customer findByUsername(String email);
}
