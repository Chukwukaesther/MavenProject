package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerRequest {
    private String CustomerId;
    private String CustomerName;
    private String PickupAddress;
    private String deliveryAddress;
    private String email;
    private String PhoneNumber;
    private String address;



}
