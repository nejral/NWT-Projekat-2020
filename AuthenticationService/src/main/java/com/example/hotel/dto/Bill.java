package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

@Data
public class Bill {


    private Long id;
    @NotNull
    private Boolean paid;
    @NotNull
    private Long userId;
    @NotNull
    private Long reservationId;
    @NotNull
    private Long createdBy;

    private LocalDateTime created;
    @NotNull
    private double cost;



}