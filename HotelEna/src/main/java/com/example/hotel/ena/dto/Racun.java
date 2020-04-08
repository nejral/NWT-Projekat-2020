package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Racun {

    private Long id;

    //private String Iznos;
    private double cost;
private Boolean paid;
    public Racun() {}

    public Racun(double cost, Long id) {
        this.cost = cost;
        this.id = id;
    }

    public Racun(Long incrementAndGet, String format) {

    }

    public double getIznos() {
        return cost;
    }

    public void setIznos(double iznos) {
        this.cost = iznos;
    }


}
