package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Setter
@Getter
public class Rider {

    @Id
    private String riderId;
    private String riderUserName;
    private  String riderPassword;
    private String serviceCharge;
    private String vehicleDetails;
    private String vehicleType;
    private String availabilityStatus;
    private String riderEmail;
    private String riderPhoneNumber;
    private String riderAddress;
    private String currentLocation;

}
