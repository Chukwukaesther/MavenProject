package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String id;
    private String Username;
    private String UserRiderPassword;
    private String UserAddress;
    private String UserPhoneNumber;
    private String UserEmail;

}
