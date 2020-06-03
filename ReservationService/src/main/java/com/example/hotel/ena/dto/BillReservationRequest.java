package com.example.hotel.ena.dto;

import lombok.*;
import javax.validation.constraints.*;
import java.io.*;
import java.util.Date;

@Data
public class BillReservationRequest implements Serializable {
    private Long reservationId;
    private Long createdBy;
    private Long userId;
    private double cost;




}