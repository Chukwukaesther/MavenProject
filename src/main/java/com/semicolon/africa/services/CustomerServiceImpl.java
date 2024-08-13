package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Customer;
import com.semicolon.africa.data.repository.CustomerRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl  implements CustomerService{


    private final CustomerRepository userRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productServiceImpl;

    public CustomerServiceImpl(CustomerRepository userRepository, CustomerRepository customerRepository, ProductRepository productRepository, ProductServiceImpl productServiceImpl) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public RegisterCustomerResponse registerUser(RegisterCustomerRequest registerCustomerRequest) {
        Customer customer = new Customer();
        String username = registerCustomerRequest.getUsername();
        validateUser(username);
        customer.setUsername(registerCustomerRequest.getUsername());
        customer.setAddress(registerCustomerRequest.getUserAddress());
        customer.setPassword(registerCustomerRequest.getUserRiderPassword());
        customer.setPhoneNumber(registerCustomerRequest.getUserPhoneNumber());
        customer.setCustomerEmail(registerCustomerRequest.getUserEmail());
        customer = customerRepository.save(customer);
        RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse();
        registerCustomerResponse.setMessage("Success");
        registerCustomerResponse.setUserName(customer.getUsername());
        registerCustomerResponse.setId(customer.getId());
        return registerCustomerResponse;
    }

    private void validateUser(String username) {
        for (Customer user1 : userRepository.findAll()) {
            if (user1.getUsername().equals(username)) {
                throw new UserAlreadyExistException("User already exist");
            }
        }
    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Customer customer = customerRepository.findByUsername(loginRequest.getUserName());
        if (!customer.getPassword().equals(loginRequest.getPassword()) && !customer.getUsername().equals(loginRequest.getUserName())) {
            throw new UserAlreadyExistException("user not found");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Successfully logged in");

        return loginResponse;
    }
    private boolean ifExist(String username, String password) {
        List<Customer> customers = userRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public LogoutResponse logout(logoutRequest logoutRequest) {
        return null;
    }

    @Override
    public PaymentDetailResponse payment(PaymentDetailsRequest paymentDetailsRequest) {
        return null;
    }

    @Override
    public FindRiderResponse findRider(FindRiderRequest findRiderRequest) {
        return null;
    }

    @Override
    public FeedbackResponse feedback(FeedbackRequest feedbackRequest) {
        return null;
    }




}
