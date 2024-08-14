package com.semicolon.africa.exceptions;
public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(){
        super("Invalid Password");
    }
}
