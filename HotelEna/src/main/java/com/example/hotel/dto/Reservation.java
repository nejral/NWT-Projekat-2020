package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.util.Date;

@Data
public class Reservation implements Serializable {

    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDate created;
    @NotNull
    private LocalDate validFrom;
    @NotNull
    private LocalDate validTo;
    @NotNull
    private Boolean done;
    @NotNull
    private Long roomId;
    @NotNull
    private Long hallId;


}
