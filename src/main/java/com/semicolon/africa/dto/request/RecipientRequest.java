package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipientRequest {
    private String recipientName;
    private String recipientEmail;
    private String recipientPhone;
    private String recipientAddress;
}


