package com.example.hotel.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.*;

@Data
public class ReservationEntity {

    private Long id;
    private Long userId;
    private Long createdBy;
    private LocalDate created;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean done;
    private Long hallId;
    private Long roomId;


}
