package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRiderResponse {
    private String riderName;
    private String riderEmail;
    private String riderPhone;
    private String riderAddress;
    private String message;

}
