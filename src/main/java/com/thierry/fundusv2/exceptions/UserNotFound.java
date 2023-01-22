package com.thierry.fundusv2.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message){
        super(message);
    }
}
