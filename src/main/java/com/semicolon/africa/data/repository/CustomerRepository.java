package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByUserName(String userName) ;
    Customer findByCurrentLocation(String currentLocation);


    boolean existByUsername(String username);
}
