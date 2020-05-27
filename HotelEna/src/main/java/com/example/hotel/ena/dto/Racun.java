package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Racun implements Serializable{

    @NotNull
    private Long id;

    @NotNull
    private double iznos;

    @NotNull
    private Long reservationId;

}