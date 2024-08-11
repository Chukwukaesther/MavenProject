package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PickupResponse {
    private String pickupId;
    private String pickupCustomerName;
    private String pickupAddress;
    private String itemName;
    private String message;


}
