package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter

public class Product {
    @Id
    private String productId;
    private String ProductName;
    private double ProductPrice;
    private String quantity;
    private String ProductCategory;



}

