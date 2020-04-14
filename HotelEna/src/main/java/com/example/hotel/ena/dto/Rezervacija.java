package com.example.hotel.ena.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
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
