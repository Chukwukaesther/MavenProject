package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Delivery {
    @Id
    private int ReceiverId;
    private String ReceiverName;
    private String ReceiverAddress;
    private String ReceiverPhone;
    private String email;
    private String DeliveryDate;
    private String DeliveryStatus;

    @DBRef
    private Customer customer;
    private Rider rider;


}
