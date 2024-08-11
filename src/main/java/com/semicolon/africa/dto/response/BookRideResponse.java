package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookRideResponse {
    private int bookRideId;
    private boolean isAvailable;
    private String location;
    private String message;
}
