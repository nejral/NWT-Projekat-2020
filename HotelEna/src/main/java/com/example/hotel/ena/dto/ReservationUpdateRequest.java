package com.example.hotel.ena.dto;

import java.io.*;
import java.time.*;
import java.util.*;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ReservationUpdateRequest implements Serializable {
    @NotNull
    private Long userId;
    @NotNull
    private Date validFrom;
    @NotNull
    private Date validTo;
    @NotNull
    private Boolean done;

}
