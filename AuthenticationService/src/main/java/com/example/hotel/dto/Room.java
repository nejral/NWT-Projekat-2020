package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class Room {
    @NotNull
    private Long numOfBeds;
    private Boolean busy;
}
