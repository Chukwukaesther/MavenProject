package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReadPreference;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByUserName(String userName) ;
    Customer findByEmail(String email);


}
