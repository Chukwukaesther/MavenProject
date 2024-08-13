package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class DeliveryInformationRequest {
    private int deliveryId;
    private String deliveryLocation;
    private String deliveryStatus;
    private LocalDateTime deliveryDate;
    private String receiverPhoneNumber;
    private String receiverName;
    private String productName;

}
