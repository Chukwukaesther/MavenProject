package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter

public class Item {
    @Id
    private String id;
    private String itemName;
    private double itemPrice;
    private int quantity;



}

