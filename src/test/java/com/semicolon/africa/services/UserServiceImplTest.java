package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.LoginRequest;
import com.semicolon.africa.dto.request.RegisterUserRequest;
import com.semicolon.africa.exceptions.RiderAlreadyExistException;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        riderRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void testThatUserCanRegister() {
        RegisterUserRequest registerUser = new RegisterUserRequest();
        registerUser.setUsername("coutinho");
        registerUser.setUserRiderPassword("234");
        registerUser.setUserAddress("Sabo");
        registerUser.setUserEmail("coutinho@gmail.com");
        userService.registerUser(registerUser);
        assertEquals(1, userRepository.count());



    }

    @Test
    public void testThatUserCannotRegisterTwice() {
        RegisterUserRequest registerUser = new RegisterUserRequest();
        registerUser.setUsername("Ether");
        registerUser.setUserRiderPassword("235");
        registerUser.setUserAddress("festac");
        registerUser.setUserEmail("Esther@gmail.com");
        userService.registerUser(registerUser);
        assertThrows(UserAlreadyExistException.class, () -> userService.registerUser(registerUser));
    }

    @Test
    public void testThatUserCanLogin(){
        RegisterUserRequest registerUser = new RegisterUserRequest();
        registerUser.setUsername("coutinho1");
        registerUser.setUserRiderPassword("2344");
        registerUser.setUserAddress("Sabo");
        registerUser.setUserEmail("coutinho1@gmail.com");
        userService.registerUser(registerUser);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("coutinho1");
        loginRequest.setPassword("2344");
        userServiceImpl.login(loginRequest);
        assertEquals(1, userRepository.count());



    }

}