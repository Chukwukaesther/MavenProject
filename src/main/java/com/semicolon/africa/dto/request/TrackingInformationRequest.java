package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackingInformationRequest {
    private String trackingId;
    private String deliveryStatusUpdate;
    private String PickupStatusUpdate;
    private String RiderName;
    private String RiderEmail;
    private String RiderPhone;
    private String RiderAddress;
    private String ItemId;
    private String ItemName;
    private String RiderCurrentLocation;


}
