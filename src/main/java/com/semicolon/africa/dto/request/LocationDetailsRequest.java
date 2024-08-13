package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocationDetailsRequest {
    private int locationId;
    private String locationName;
    private String locationAddress;

}
