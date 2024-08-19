package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
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
    private String password;
    private String phoneNumber;
    private String currentLocation;
    private String customerCurrentLocation;
    private String existByUsername;
    private List <String> feedBack = new ArrayList<String>();

    @DBRef
    private List<Product> productList;
    private List<Rider> riderList;


}
