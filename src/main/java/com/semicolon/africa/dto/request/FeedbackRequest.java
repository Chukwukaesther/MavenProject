package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackRequest {
    private String customerId;
    private String feedback;
}
