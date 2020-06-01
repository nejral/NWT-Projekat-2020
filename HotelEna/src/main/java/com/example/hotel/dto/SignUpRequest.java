package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;


@Data
public class SignUpRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String surname;
}
