package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;
import java.sql.*;

@Data
public class Rezervacija implements Serializable {


    @NotNull
    private Long userId;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date created;
    @NotNull
    private Date validFrom;
    @NotNull
    private Date validTo;


}
