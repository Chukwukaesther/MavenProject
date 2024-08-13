package com.semicolon.africa.services;

import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

import java.util.List;

public interface CustomerService {
    RegisterCustomerResponse registerUser(RegisterCustomerRequest registerCustomerRequest);
    LoginResponse login(LoginRequest loginRequest);
    LogoutResponse logout(logoutRequest logoutRequest);
    PaymentDetailResponse payment(PaymentDetailsRequest paymentDetailsRequest);
    FindRiderResponse findRider(FindRiderRequest findRiderRequest);
    FeedbackResponse feedback(FeedbackRequest feedbackRequest);




}
