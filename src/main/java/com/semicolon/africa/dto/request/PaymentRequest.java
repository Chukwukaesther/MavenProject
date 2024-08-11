package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PaymentRequest {
    private String Id;
    private double amount;
    private String PaymentType;
    private String paymentStatus;
    private LocalDateTime paymentDate;
}
