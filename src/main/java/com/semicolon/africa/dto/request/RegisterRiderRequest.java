package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRiderRequest {
    private String riderName;
    private String riderPassword;
    private String riderEmail;
    private String riderPhone;
    private String riderAddress;


}
