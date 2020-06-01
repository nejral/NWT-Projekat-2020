package com.example.hotel.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.*;

@Data
public class Hall implements Serializable {
    private Long id;
    @NotNull
    private Long numberOfPeople;
    private Boolean busy;
}
