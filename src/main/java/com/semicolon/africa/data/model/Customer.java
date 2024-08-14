package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Setter
@Getter
public class Customer {

    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private List <String> feedBack = new ArrayList<String>();

    @DBRef
    private List<Product> productList;
    private List<Rider> riderList;
}
