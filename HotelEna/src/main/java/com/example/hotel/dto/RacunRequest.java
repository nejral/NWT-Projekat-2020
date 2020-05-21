package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;
import java.util.*;

@Data
public class RacunRequest implements Serializable {

    private Long id;
    @NotNull(message = "Cost is mandatory")
    //@Size(min=5, max=30)
    private double cost;
    @NotNull(message = "Paid is mandatory")
    private Boolean paid;
    @NotNull(message = "Reservation ID is mandatory")
    private Long reservationId;
    @NotNull(message = "CreatedBy is mandatory")
    //@Size(min=5, max=10)
    private Long createdBy;
    //@NotNull(message = "Created is mandatory")
    private Date created;
    @NotNull(message = "userId is mandatory")
    private Long userId;





}
