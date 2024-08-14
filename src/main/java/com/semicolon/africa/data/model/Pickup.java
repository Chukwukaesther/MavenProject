package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Pickup {
    @Id
    private String pickupId;
    private String pickupName;
    private String pickupAddress;
    private String pickupPhoneNumber;
    private String pickupEmail;

    @DBRef
    private Customer customer;
    private Rider rider;
}
