package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{




}
