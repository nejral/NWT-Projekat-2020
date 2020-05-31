package com.example.hotel.dto;

import lombok.*;

import java.io.*;

@Data
public class Sala implements Serializable {
    private Long id;
    private Long numberOfPeople;
    private Boolean busy;
}
