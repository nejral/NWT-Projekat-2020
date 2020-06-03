package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;
import java.util.*;

@Data
public class BillRequest implements Serializable {

    private Long id;
    @NotNull(message = "Cost is mandatory")
    private double cost;
    @NotNull(message = "Paid is mandatory")
    private Boolean paid;
    @NotNull(message = "Reservation ID is mandatory")
    private Long reservationId;
    @NotNull(message = "CreatedBy is mandatory")
    private Long createdBy;
    private Date created;
    @NotNull(message = "userId is mandatory")
    private Long userId;





}
