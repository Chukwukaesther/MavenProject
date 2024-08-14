package com.semicolon.africa.dto.response;

import com.semicolon.africa.data.model.Rider;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindRiderResponse {
    private int status;
    private String message;
    private Rider rider;
}
