package com.thierry.fundusv2.exceptions;

public class DonationNotFound extends RuntimeException {
    public DonationNotFound(String message){
        super(message);
    }
}

