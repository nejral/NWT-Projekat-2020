package com.example.hotel.ena.dto;

import lombok.*;

import javax.validation.constraints.*;
@Data
public class KorisnikLoginRequest {

    @NotBlank(message = "Password is mandatory")
    @Size(min=5, max=10)
    private String password;

    @NotBlank(message = "Username is mandatory")
    @Size(min=5, max=30)
    private String username;



}
