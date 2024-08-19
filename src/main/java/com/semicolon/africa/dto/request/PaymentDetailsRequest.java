package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PaymentDetailsRequest {

    private String paymentName;
    private Double paymentAmount;
    private String paymentType;
    private String paymentStatus;
    private LocalDateTime paymentDate;
}
