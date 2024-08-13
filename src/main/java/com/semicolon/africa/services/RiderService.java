package com.semicolon.africa.services;

import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

public interface RiderService {
    RegisterRiderResponse registerRider(RegisterRiderRequest Request);
    LoginResponse login(LoginRequest loginRequest);
    LogoutResponse logout(logoutRequest request);
    PickupResponse pickup(PickupRequest pickupRequest);
    DeliverResponse deliver(DeliveryInformationRequest DeliveryInformationRequest);





}
