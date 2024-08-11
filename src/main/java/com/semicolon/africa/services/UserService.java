package com.semicolon.africa.services;

import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginRequest loginRequest);
    LogoutResponse logout(logoutRequest logoutRequest);
    PaymentResponse payment(PaymentRequest paymentRequest);
    BookRideResponse bookRide(BookRideRequest bookRideRequest);
    CallRiderResponse callRider(CallRiderRequest callRiderRequest);

}
