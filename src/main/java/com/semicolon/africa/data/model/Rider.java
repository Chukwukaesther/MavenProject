package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private String availabilityStatus;
    private String riderEmail;
    private String riderPhoneNumber;
    private String riderAddress;
    private String currentLocation;

    @DBRef
    private List<Product> productList;
    private List<Customer> customerList;
    private List<Pickup> pickupList;
    private List <Delivery> deliveryList;

}
