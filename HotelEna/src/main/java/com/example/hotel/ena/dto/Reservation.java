package com.example.hotel.ena.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.*;
import java.util.Date;

@Data
public class Reservation implements Serializable {
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDate created;
    @NotNull
    private LocalDate validFrom;
    @NotNull
    private LocalDate validTo;
    @NotNull
    private Boolean done;
    @NotNull
    private Long roomId;
    @NotNull
    private Long hallId;


    public Reservation(Long userId, Long createdBy, LocalDate created, LocalDate validFrom, LocalDate validTo) {
        this.userId = userId;
        this.createdBy = createdBy;
        this.created = created;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
public Long getHallId(){
        return this.hallId;
}
public void setHallId(Long hallId){
        this.hallId=hallId;
}
public Long getRoomId(Long roomId){
        return this.roomId;
}
public void setRoomId(Long roomId){
        this.roomId=roomId;
}
    public Reservation(){ }
public Long getId(){ return id;}
public void setId(Long id){ this.id=id;}
public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }
}
