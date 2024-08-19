package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

public interface RiderService {
    RegisterRiderResponse registerRider(RegisterRiderRequest Request);
    LoginResponse login(LoginRequest loginRequest);
    LogoutResponse logout(LogoutRequest request);
    PickupResponse pickUp(PickupRequest pickupRequest);
    DeliverResponse deliver(DeliveryInformationRequest DeliveryInformationRequest);


    Rider FindRiderByCurrentLocation(String riderLocation);
}
