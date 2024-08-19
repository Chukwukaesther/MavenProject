package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterCustomerRequest {
    private String Username;
    private String Password;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;

}
