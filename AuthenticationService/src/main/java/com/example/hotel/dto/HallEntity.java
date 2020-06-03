package com.example.hotel.dto;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
public class HallEntity {
    private Long id;
    private Long numberOfPeople;
    private Boolean busy;



}
