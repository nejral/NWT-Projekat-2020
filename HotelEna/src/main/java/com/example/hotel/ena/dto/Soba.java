package com.example.hotel.ena.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class Soba implements Serializable {

    @NotNull
    private Blob slike;

    @NotNull
    private int numberOfBeds;

    @NotNull
    private boolean busy;

    public Soba(Blob slike, int numberOfBeds, boolean busy) {
        this.slike = slike;
        this.numberOfBeds = numberOfBeds;
        this.busy = busy;
    }

    public Soba(){}

    public Blob getSlike() {
        return slike;
    }

    public void setSlike(Blob slike) {
        this.slike = slike;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
