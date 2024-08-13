package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class ProductRequest {
    @Id
    private String ProductId;
    private String productName;
    private double productPrice;
    private String productQuantity;
    private String productCategory;


}
