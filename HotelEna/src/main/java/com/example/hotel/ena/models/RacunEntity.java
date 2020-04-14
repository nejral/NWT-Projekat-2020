package com.example.hotel.ena.models;
import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
//import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@Table(name = "racun_entity")
public class RacunEntity {


    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NotNull
    @Column
    private Long userId;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @NotNull
    private Long createdBy;

    public void setCost(double cost) {
        this.cost = cost;
    }

    @NotNull
    private Date created;

    @NotNull
    @Column
    private double cost;
    @NotNull
    private Long reservationId;


    //@AssertTrue
    @Column

    private Boolean paid;

    public RacunEntity() {
    }

    public RacunEntity(Object o, Long reservationId, double cost, Long userId, Boolean b) {
        this.setReservationId(reservationId);
        this.setCost(cost);
        this.setUserId(userId);
        this.setPaid(b);

    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }


    public double getCost() {
        return cost;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
