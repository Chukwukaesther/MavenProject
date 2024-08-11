package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookRideRequest {
    private String rideId;
    private String riderName;
    private String pickupTime;
    private String deliveryTime;
    private String destination;




}
