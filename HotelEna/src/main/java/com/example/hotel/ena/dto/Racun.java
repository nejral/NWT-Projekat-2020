package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Data
public class Racun {


    @NotNull
    private Boolean paid;
    @NotNull
    private Long userId;
    @NotNull
    private Long reservationId;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date created;
    @NotNull
    private double cost;



}