package com.example.hotel.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
public class RoomEntity {

    private Long id;

    private byte[] slike;

    private Long numberOfBeds;

    private boolean busy;
}
