package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickupRequest {
    private int pickupId;
    private String pickupCustomerName;
    private String pickupAddress;
    private String pickupPhoneNumber;


}
