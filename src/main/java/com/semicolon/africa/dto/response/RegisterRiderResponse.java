package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRiderResponse {
    private String RiderName;
    private String RiderEmail;
    private String RiderPhone;
    private String RiderAddress;
    private String message;

}
