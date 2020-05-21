package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
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