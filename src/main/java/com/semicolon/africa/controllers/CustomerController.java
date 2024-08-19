package com.semicolon.africa.controllers;

import com.semicolon.africa.dto.request.LoginRequest;
import com.semicolon.africa.dto.request.RegisterCustomerRequest;
import com.semicolon.africa.dto.response.ApiResponse;
import com.semicolon.africa.dto.response.LoginResponse;
import com.semicolon.africa.dto.response.RegisterCustomerResponse;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import com.semicolon.africa.services.CustomerService;
import com.semicolon.africa.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/User")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterCustomerRequest registerCustomerRequest) {
        try {
            RegisterCustomerResponse result = customerService.registerUser(registerCustomerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (UserAlreadyExistException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);

        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse result = customerService.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), HttpStatus.OK);
        } catch (UserAlreadyExistException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);

        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}