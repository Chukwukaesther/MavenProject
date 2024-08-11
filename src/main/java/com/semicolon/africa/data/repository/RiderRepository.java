package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderRepository extends MongoRepository<Rider, String> {
         Rider findRiderByRiderUserNameIgnoreCase(String username);

}


