package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrackingInformationResponse {
    private String trackingId;
    private String trackingStatus;
    private String message;
}
