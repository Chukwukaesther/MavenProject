package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PickupRequest {
    private String pickupCustomerName;
    private String pickupAddress;
    private String pickupCustomersPhoneNumber;
    private String itemName;

}
