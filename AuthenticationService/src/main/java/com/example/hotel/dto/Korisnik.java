package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;

@Data
public class Korisnik implements Serializable {

    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String password;
    private Boolean employeeInd;
    private String email;
    private String role;




}
