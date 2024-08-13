package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.data.repository.CustomerRepository;
import com.semicolon.africa.dto.request.LoginRequest;
import com.semicolon.africa.dto.request.RegisterCustomerRequest;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private CustomerServiceImpl userServiceImpl;
    @Autowired
    private CustomerRepository userRepository;

    @BeforeEach
    void setUp() {
        riderRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void testThatUserCanRegister() {
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("coutinho");
        registerUser.setUserRiderPassword("234");
        registerUser.setUserAddress("Sabo");
        registerUser.setUserEmail("coutinho@gmail.com");
        customerService.registerUser(registerUser);
        assertEquals(1, userRepository.count());



    }

    @Test
    public void testThatUserCannotRegisterTwice() {
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("Ether");
        registerUser.setUserRiderPassword("235");
        registerUser.setUserAddress("festac");
        registerUser.setUserEmail("Esther@gmail.com");
        customerService.registerUser(registerUser);
        assertThrows(UserAlreadyExistException.class, () -> customerService.registerUser(registerUser));
    }

    @Test
    public void testThatUserCanLogin(){
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("coutinho1");
        registerUser.setUserRiderPassword("2344");
        registerUser.setUserAddress("Sabo");
        registerUser.setUserEmail("coutinho1@gmail.com");
        customerService.registerUser(registerUser);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("coutinho1");
        loginRequest.setPassword("2344");
        userServiceImpl.login(loginRequest);
        assertEquals(1, userRepository.count());



    }

}