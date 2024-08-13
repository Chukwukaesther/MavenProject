package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PaymentDetailsRequest {

    private String PaymentName;
    private Double PaymentAmount;
    private String PaymentType;
    private String paymentStatus;
    private LocalDateTime paymentDate;
}
