package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RiderDetailsRequest {
    private int riderId;
    private String riderUserName;
    private String riderPassword;
    private String riderEmail;
    private String riderPhoneNumber;
    private String riderAddress;
    private String CurrentLocation;
    private String riderAccountDetails;
}
