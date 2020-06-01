package com.example.hotel.ena.dto;

import lombok.*;

import java.io.*;
@Data
public class Hall implements Serializable {
    private Long id;
    private Long numberOfPeople;
    private Boolean busy;
}
