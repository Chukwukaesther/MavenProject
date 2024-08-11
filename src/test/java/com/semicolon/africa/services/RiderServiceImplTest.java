package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.dto.request.LoginRequest;
import com.semicolon.africa.dto.request.RegisterRiderRequest;
import com.semicolon.africa.dto.response.LoginResponse;
import com.semicolon.africa.exceptions.RiderAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RiderServiceImplTest {

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private RiderServiceImpl riderServiceImpl;

    @BeforeEach
    void setUp() {
//
        riderRepository.deleteAll();

    }

    @Test
    void TestThatRidersCanRegister() {
        RegisterRiderRequest registerRider = new RegisterRiderRequest();
        registerRider.setRiderName("coutinho");
        registerRider.setRiderEmail("coutinho@gmail.com");
        registerRider.setRiderPassword("1234");
        registerRider.setRiderAddress("Festac town");
        registerRider.setRiderPhone("0812345678");
        riderServiceImpl.registerRider(registerRider);

        registerRider.setRiderName("Esther");
        registerRider.setRiderEmail("Esther@gmail.com");
        registerRider.setRiderAddress("Satellite town");
        registerRider.setRiderPhone("0809876543");
        riderServiceImpl.registerRider(registerRider);
        assertEquals(2, riderRepository.count());

    }

    @Test
    void TestThatRidersCanLogin() {


        LoginRequest loginRider = new LoginRequest();
        loginRider.setUserName("Esther");
        loginRider.setPassword("1234");
        riderServiceImpl.login(loginRider);
        LoginResponse response = new LoginResponse();
        response.setMessage("Login successful");
        assertEquals(true, riderRepository.findRiderByRiderUserNameIgnoreCase("esther").isLoggedIn());




    }
    @Test
    public void testThatRiderCannotRegisterTwice() {
        RegisterRiderRequest registerRider = new RegisterRiderRequest();
        registerRider.setRiderName("coutinho");
        registerRider.setRiderEmail("coutinho@gmail.com");
        registerRider.setRiderPassword("1234");
        registerRider.setRiderAddress("Festac town");
        registerRider.setRiderPhone("0812345678");
        riderServiceImpl.registerRider(registerRider);
        assertThrows(RiderAlreadyExistException.class, () -> riderServiceImpl.registerRider(registerRider));
    }





}