package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Racun {

    private Long id;

    //private String Iznos;
    private double iznos;

    public Racun() {}

    public Racun(double iznos, Long id) {
        this.iznos = iznos;
        this.id = id;
    }

    public Racun(Long incrementAndGet, String format) {

    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }


}
