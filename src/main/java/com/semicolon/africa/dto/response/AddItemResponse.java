package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddItemResponse {
    private int id;
    private String itemName;
    private double itemPrice;
    private String message;
}
