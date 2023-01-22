package com.thierry.fundusv2.exceptions;

public class RequestNotFound extends RuntimeException{
    public RequestNotFound(String message){
        super(message);
    }
}
