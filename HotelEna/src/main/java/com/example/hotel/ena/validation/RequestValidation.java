package com.example.hotel.ena.validation;

import org.springframework.stereotype.Component;

@Component
public class RequestValidation {
    public String validateUsername(String username){
        if(username.isEmpty() || username==null){
            return "Username required";
        }
        return null;
    }
}
