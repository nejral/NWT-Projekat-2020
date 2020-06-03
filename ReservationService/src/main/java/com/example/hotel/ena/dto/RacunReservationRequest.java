package com.example.hotel.ena.dto;

import lombok.*;
import javax.validation.constraints.*;
import java.io.*;
import java.util.Date;

@Data
public class RacunReservationRequest implements Serializable {
    @NotNull
    private Long id;
    @NotNull
    private double cost;
    private Boolean paid;
    private Long reservationId;
    private Long createdBy;
    private Date created;
    private Long userId;



}