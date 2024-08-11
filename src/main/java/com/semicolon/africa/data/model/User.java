package com.semicolon.africa.data.model;

import com.semicolon.africa.category.UserCategory;
import com.semicolon.africa.data.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Setter
@Getter
public class User {

    @Id
    private String id;
    private String name;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    @DBRef
    private List<Item> itemList;
}
