package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Customer;
import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.CustomerAndRiderLocationAreNotSame;

public interface CustomerService {
    RegisterCustomerResponse registerUser(RegisterCustomerRequest registerCustomerRequest);
    LoginResponse login(LoginRequest loginRequest);
    FindRiderResponse findRiderByCurrentLocation(FindRiderRequest findRiderRequest) throws CustomerAndRiderLocationAreNotSame;

    Rider findRiderByCurrentLocation(String riderLocation);

    Customer findByCurrentLocation(String currentLocation);

    PaymentDetailResponse payment(PaymentDetailsRequest paymentDetailsRequest);
    FeedbackResponse feedback(FeedbackRequest feedbackRequest);
    LogoutResponse logout(LogoutRequest logoutRequest);






}
