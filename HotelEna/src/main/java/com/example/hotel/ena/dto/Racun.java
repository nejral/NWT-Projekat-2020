package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class Racun {



    private Long id;
    @NotNull
    private Boolean paid;
    @NotNull
    private Long userId;
    @NotNull
    private Long reservationId;
    @NotNull
    private Long createdBy;

    private Date created;
    @NotNull
    private double cost;

    public Racun() {}

    public Racun(double cost, Long id, Boolean paid,Long reservationId,Long createdBy,Date created,Long userId) {
        this.cost = cost;
        this.id = id;
        this.paid=paid;
        this.reservationId=reservationId;
        this.createdBy=createdBy;
        this.created=created;
        this.userId=userId;
    }

    public Racun(Long incrementAndGet, String format) {

    }

    public double getCost() {
        return cost;
    }
    public Long getId() { return id;}

    public void setCost(double cost) {
        this.cost = cost;
    }


}
