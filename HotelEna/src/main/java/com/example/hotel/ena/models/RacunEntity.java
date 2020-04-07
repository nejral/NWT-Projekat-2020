package com.example.hotel.ena.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
@Entity
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
    private String createdBy;
    @NotNull
    private String created;

    @NotNull
    @Column
    private double cost;
    @NotNull
    private String reservation_id;

    @AssertTrue
    @Column

    private Boolean paid;

    public RacunEntity() {
    }

    public Long getId() {
        return this.id;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(final Long userId){
        this.userId = userId;
    }
    public String getReservationId() {
        return this.reservation_id;
    }

    public void setReservationId(final String reservationId){
        this.reservation_id = reservationId;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(final String created){
        this.created = created;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(final String createdBy){
        this.createdBy = createdBy;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(final double cost){
        this.cost = cost;
    }

    public Boolean getPaid() {
        return this.paid;
    }

    public void setPaid(final Boolean paid){
        this.paid = paid;
    }


}
