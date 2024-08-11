package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.data.model.User;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.RiderAlreadyExistException;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        validateUser(registerUserRequest);
        user.setUserName(registerUserRequest.getUsername());
        user.setAddress(registerUserRequest.getUserAddress());
        user.setPhoneNumber(registerUserRequest.getUserPhoneNumber());
        user.setEmail(registerUserRequest.getUserEmail());
        userRepository.save(user);
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("Success");
        return registerUserResponse;
    }

    private void validateUser(RegisterUserRequest registerUserRequest) {
        for(User User : userRepository.findAll()) {
            if(User.getUserName().equals(registerUserRequest.getUsername())){
                throw new UserAlreadyExistException("User already exist");
            }
        }
    }




    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();

        boolean isExist = ifExist(username,password);
        if(isExist){
            throw new RuntimeException("Username or password doesn't match");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Successfully logged in");

        return loginResponse;
    }
    private boolean ifExist(String username, String password) {
        List<User> users = userRepository.findAll();
        for(User user : users) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }



    @Override
    public LogoutResponse logout(logoutRequest logoutRequest) {
        userRepository.findUserByEmail(logoutRequest.getUserName());
        String username = logoutRequest.getUserName();
        boolean isExist = ifExist(username,username);
        if(isExist){
            throw new RuntimeException("Username doesn't match");
        }
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setMessage("Successfully logged out");

        return logoutResponse;
    }

    @Override
    public PaymentResponse payment(PaymentRequest paymentRequest) {
        PaymentResponse response = new PaymentResponse();


        return null;
    }

    @Override
    public BookRideResponse bookRide(BookRideRequest bookRideRequest) {
        return null;
    }

    @Override
    public CallRiderResponse callRider(CallRiderRequest callRiderRequest) {
        return null;
    }
}
