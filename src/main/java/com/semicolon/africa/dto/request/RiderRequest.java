package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class RiderRequest {
    private String riderUserName;
    private String riderPassword;
    private String riderEmail;
    private String riderPhone;
    private String riderAddress;
}
