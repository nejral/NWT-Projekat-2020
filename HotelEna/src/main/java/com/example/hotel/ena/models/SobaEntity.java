package com.example.hotel.ena.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "sobaentity")
public class SobaEntity {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToOne
    private Long id;

    @OneToOne(mappedBy = "sobaentity")
    private RezervacijaEntity rezervacijaentity;

    @Column
    private Blob slike;

    @Column
    private int numberOfBeds;

    @Column
    private boolean busy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public SobaEntity() {
    }
}
