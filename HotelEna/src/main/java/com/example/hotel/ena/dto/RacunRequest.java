package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class RacunRequest implements Serializable {

    private Long id;
    @NotBlank(message = "Cost is mandatory")
    //@Size(min=5, max=30)
    private double cost;
    @NotBlank(message = "Paid is mandatory")
    private Boolean paid;
    @NotBlank(message = "Reservation ID is mandatory")
    private Long reservationId;
    @NotBlank(message = "CreatedBy is mandatory")
    //@Size(min=5, max=10)
    private Long createdBy;
    @NotBlank(message = "Created is mandatory")
    private Date created;
    @NotBlank(message = "userId is mandatory")
    private Long userId;





}
