package com.semicolon.africa.controllers;

import com.semicolon.africa.dto.request.RegisterCustomerRequest;
import com.semicolon.africa.dto.request.RegisterRiderRequest;
import com.semicolon.africa.dto.response.ApiResponse;
import com.semicolon.africa.dto.response.RegisterCustomerResponse;
import com.semicolon.africa.dto.response.RegisterRiderResponse;
import com.semicolon.africa.exceptions.RiderAlreadyExistException;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import com.semicolon.africa.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/Rider")
public class RiderController {

    @Autowired
    private RiderService riderService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRiderRequest registerCustomerRequest) {
        try {
            RegisterRiderResponse result = riderService.registerRider(registerCustomerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (RiderAlreadyExistException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);

        }
    }



}
