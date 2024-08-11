package com.semicolon.africa.controllers;

import com.semicolon.africa.dto.request.RegisterUserRequest;
import com.semicolon.africa.dto.response.ApiResponse;
import com.semicolon.africa.dto.response.RegisterUserResponse;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import com.semicolon.africa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            RegisterUserResponse result = userService.registerUser(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (UserAlreadyExistException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);

        }
    }

}