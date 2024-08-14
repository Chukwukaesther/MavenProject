package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindRiderRequest {
    private int riderId;
    private String riderUsername;
    private String riderCurrentLocation;
}
