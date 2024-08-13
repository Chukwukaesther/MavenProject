package com.semicolon.africa.services;
import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.data.repository.CustomerRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

import com.semicolon.africa.exceptions.RiderAlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RiderServiceImpl implements RiderService {
    private final RiderRepository riderRepository;
    private final CustomerRepository userRepository;

    @Override
    public RegisterRiderResponse registerRider(RegisterRiderRequest request) {
        Rider rider = new Rider();
        validate(request);
        rider.setRiderUserName(request.getRiderName());
        rider.setRiderPassword(request.getRiderPassword());
        rider.setRiderAddress(request.getRiderAddress());
        rider.setRiderEmail(request.getRiderEmail());
        rider.setRiderPhoneNumber(request.getRiderPhone());
        riderRepository.save(rider);
        RegisterRiderResponse response = new RegisterRiderResponse();
        response.setMessage("Registration Successful");
        return response;
    }

    private void validate(RegisterRiderRequest request) {
        for(Rider rider1 : riderRepository.findAll()) {
            if(rider1.getRiderUserName().equals(request.getRiderName())){
                throw new RiderAlreadyExistException("Rider already exist");
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
        LoginResponse response = new LoginResponse();
        response.setMessage("Login Successful");
        return response;
    }

    private boolean ifExist(String username, String password) {
        List<Rider> riders = riderRepository.findAll();
        for(Rider rider : riders){
            if(rider.getRiderUserName().equals(username) && rider.getRiderPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    @Override
    public LogoutResponse logout(logoutRequest request){
       // riderRepository.findRiderByRiderUserNameIgnoreCase(request.getUserName());

        String username = request.getUserName();
        boolean isAmong = ifAmong(username);
        if (isAmong) {
            throw new RuntimeException("Username doesn't match");
        }
        LogoutResponse response = new LogoutResponse();
        response.setMessage("Logout Successful");
        return response;
    }


    private boolean ifAmong(String username) {
        List<Rider> riders = riderRepository.findAll();
        for (Rider rider : riders) {
            if (rider.getRiderUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public PickupResponse pickup(PickupRequest pickupRequest){
        RiderRepository rider = this.riderRepository;
        rider.findRiderByRiderUserName(pickupRequest.getPickupCustomerName());
        PickupResponse response = new PickupResponse();
        response.setMessage("Pickup Successful");

        return response;
    }

    @Override
    public DeliverResponse deliver(DeliveryInformationRequest deliveryInformationRequest) {
        DeliveryInformationRequest deliveryInformationRequest1 = new DeliveryInformationRequest();
        deliveryInformationRequest1.setDeliveryId(deliveryInformationRequest.getDeliveryId());
        deliveryInformationRequest1.setDeliveryLocation(deliveryInformationRequest.getDeliveryLocation());
        deliveryInformationRequest1.setDeliveryStatus(deliveryInformationRequest.getDeliveryStatus());
        deliveryInformationRequest1.setProductName(deliveryInformationRequest.getProductName());
        deliveryInformationRequest1.setReceiverPhoneNumber(deliveryInformationRequest.getReceiverPhoneNumber());
        deliveryInformationRequest1.setReceiverName(deliveryInformationRequest.getReceiverName());


        DeliverResponse response = new DeliverResponse();


        return null;
    }
}

