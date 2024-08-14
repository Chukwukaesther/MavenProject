package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Customer;
import com.semicolon.africa.data.model.Rider;
import com.semicolon.africa.data.repository.CustomerRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.data.repository.RiderRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.UserAlreadyExistException;
import com.semicolon.africa.exceptions.customerDoesNotException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl  implements CustomerService{
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private  RiderRepository riderRepository;


    @Override
    public RegisterCustomerResponse registerUser(RegisterCustomerRequest registerCustomerRequest) {
        Customer customer = new Customer();
        String username = registerCustomerRequest.getUsername();
        validateUser(username);
        customer.setUserName(registerCustomerRequest.getUsername());
        customer.setAddress(registerCustomerRequest.getUserAddress());
        customer.setPassword(registerCustomerRequest.getUserRiderPassword());
        customer.setPhoneNumber(registerCustomerRequest.getUserPhoneNumber());
        customer.setEmail(registerCustomerRequest.getUserEmail());
        customer = customerRepository.save(customer);
        RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse();
        registerCustomerResponse.setMessage("Success");
        registerCustomerResponse.setUserName(customer.getUserName());
        registerCustomerResponse.setId(customer.getId());
        return registerCustomerResponse;
    }

    private void validateUser(String username) {
        for (Customer user1 : customerRepository.findAll()){
            if (user1.getUserName().equals(username)) {
                throw new UserAlreadyExistException("User already exist");
            }
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Customer customer = customerRepository.findByUserName(loginRequest.getUserName());
        if (!customer.getPassword().equals(loginRequest.getPassword()) && !customer.getUserName().equals(loginRequest.getUserName())) {
            throw new UserAlreadyExistException("user not found");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Successfully logged in");

        return loginResponse;
    }
    private boolean ifExist(String username, String password) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getUserName().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public FindRiderResponse findRider(FindRiderRequest findRiderRequest) {
        Rider rider1 = riderRepository.findRiderByCurrentLocation(findRiderRequest.getRiderCurrentLocation());
        rider1.setCurrentLocation(findRiderRequest.getRiderCurrentLocation());
        Rider rider= riderRepository.save(rider1);
        FindRiderResponse response = new FindRiderResponse();
        response.setMessage("Rider found");
        return response;

    }



    @Override
    public PaymentDetailResponse payment(PaymentDetailsRequest paymentDetailsRequest) {
        Customer customer = customerRepository.findByUserName(paymentDetailsRequest.getPaymentName());
        customerRepository.save(customer);
        Rider rider1 = riderRepository.findByRiderUserName(String.valueOf(paymentDetailsRequest.getPaymentAmount()));
        rider1.setServiceCharge(paymentDetailsRequest.getPaymentStatus());
        Rider rider2 = riderRepository.save(rider1);

        PaymentDetailResponse paymentDetailResponse = new PaymentDetailResponse();
        paymentDetailResponse.setMessage("Success");

        return paymentDetailResponse;
    }

    @Override
    public FeedbackResponse feedback(FeedbackRequest feedbackRequest) {
        Customer customer = findCustomerById(feedbackRequest.getCustomerId());
        List<String> feedbacks = customer.getFeedBack();
        feedbacks.add(feedbackRequest.getFeedback());
        customer.setFeedBack(feedbacks);
        FeedbackResponse response = new FeedbackResponse();
        response.setMessage("Thanks for your feedback");
        return response;
    }


    @Override
    public LogoutResponse logout(logoutRequest logoutRequest) {
        Customer customer = customerRepository.findByUserName(logoutRequest.getUserName());
        String username = logoutRequest.getUserName();
        boolean isExisting = ifExisting(username);
        if (isExisting) {
            throw new customerDoesNotException("Username doesn't match");
        }
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setMessage("Successfully logged out");

        return null;
    }

    private boolean ifExisting(String username) {
        for (Customer customer :customerRepository.findAll()) {
            if (customer.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }




    private Customer findCustomerById(String customerId){
        return null;

    }


}
