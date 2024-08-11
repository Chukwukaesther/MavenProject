package com.semicolon.africa.exceptions;

public class RiderAlreadyExistException extends RuntimeException {
    public RiderAlreadyExistException(String message) {
        super(message);
    }
}
