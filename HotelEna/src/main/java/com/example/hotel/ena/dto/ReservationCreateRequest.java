package com.example.hotel.ena.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;
import java.time.*;

@Data
public class ReservationCreateRequest implements Serializable {
    @NotNull
    private LocalDate validTo;
    @NotNull
    private LocalDate validFrom;
    @NotNull
    private Long userId;
    @NotNull
    private Boolean done;
    @NotNull
    private Long hallId;
    @NotNull
    private Long roomId;
@NotNull
    private double cost;
@NotNull
    private Long createdBy;
}
