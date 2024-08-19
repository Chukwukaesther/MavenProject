package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.data.repository.CustomerRepository;
import com.semicolon.africa.dto.request.CustomerRequest;
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
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RiderServiceImpl riderServiceImpl;

    @BeforeEach
    void setUp() {
        riderRepository.deleteAll();
        customerRepository.deleteAll();
    }


    @Test
    public void testThatCustomerCanRegister() {
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("coutinho");
        registerUser.setPassword("234");
        registerUser.setCustomerAddress("Sabo");
        registerUser.setCustomerEmail("coutinho@gmail.com");
        customerService.registerUser(registerUser);
        assertEquals(1, customerRepository.count());



    }

    @Test
    public void testThatCustomerCannotRegisterTwice() {
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("Ether");
        registerUser.setPassword("235");
        registerUser.setCustomerAddress("festac");
        registerUser.setCustomerEmail("Esther@gmail.com");
        customerService.registerUser(registerUser);
        assertThrows(UserAlreadyExistException.class, () -> customerService.registerUser(registerUser));
    }

    @Test
    public void testThatCustomerCanLogin(){
        RegisterCustomerRequest registerUser = new RegisterCustomerRequest();
        registerUser.setUsername("coutinho1");
        registerUser.setPassword("2344");
        registerUser.setCustomerAddress("Sabo");
        registerUser.setCustomerEmail("coutinho1@gmail.com");
        customerService.registerUser(registerUser);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("coutinho1");
        loginRequest.setPassword("2344");
        customerServiceImpl.login(loginRequest);
        assertEquals(1, customerRepository.count());



    }

    @Test
    public void testThatICanFindRiderByCurrentLocation() {












    }


}