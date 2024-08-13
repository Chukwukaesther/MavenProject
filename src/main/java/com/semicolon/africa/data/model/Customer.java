package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Setter
@Getter
public class Customer {

    @Id
    private String id;
    private String username;
    private String CustomerEmail;
    private String password;
    private String phoneNumber;
    private String address;
    @DBRef
    private List<Product> productList;
}
