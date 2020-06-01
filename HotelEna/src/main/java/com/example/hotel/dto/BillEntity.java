package com.example.hotel.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;



@AllArgsConstructor
@Data
public class BillEntity {

    private Long id;
    private Long userId;
    private Long createdBy;
    private Date created;
    private double cost;
    private Long reservationId;
    private Boolean paid;
}
