package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterCustomerRequest {
    private String username;
    private String password;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;

}
