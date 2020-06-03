package com.example.hotel.ena.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "sobaentity")
public class RoomEntity {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToOne
    private Long id;


@Lob
    @Column(name="slike",columnDefinition="BLOB")
    private byte[] slike;

    @Column
    private Long numberOfBeds;

    @Column
    private boolean busy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getSlike() {
        return slike;
    }

    public void setSlike(byte[] slike) {
        this.slike = slike;
    }

    public Long getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Long numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public RoomEntity() {
    }
}
