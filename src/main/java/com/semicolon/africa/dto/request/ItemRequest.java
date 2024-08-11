package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemRequest {
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemCategory;


}
