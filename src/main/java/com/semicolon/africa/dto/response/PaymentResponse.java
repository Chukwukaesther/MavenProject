package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PaymentResponse {
    private String paymentId;
    private String paymentName;
    private String orderId;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    private String paymentAmount;

}
