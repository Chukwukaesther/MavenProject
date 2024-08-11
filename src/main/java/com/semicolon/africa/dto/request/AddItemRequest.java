package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemRequest {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;

}
