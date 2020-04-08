package com.example.hotel.ena.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
public class RacunEntity {
    //@javax.persistence.Id
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private Long userId;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date created;

    @NotNull
    @Column
    private double cost;
    @NotNull

    private Long reservationId;

    @AssertTrue
    @Column

    private Boolean paid;

    public RacunEntity() {
    }



}
