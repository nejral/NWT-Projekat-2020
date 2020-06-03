package com.example.hotel.ena.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.*;
import java.util.Date;

@Data
public class Rezervacija implements Serializable {
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
    private Long racunId;
    @NotNull
    private Long salaentityId;
    @NotNull
    private Long sobaentityId;


    public Rezervacija(Long userId, Long createdBy, LocalDate created, LocalDate validFrom, LocalDate validTo) {
        this.userId = userId;
        this.createdBy = createdBy;
        this.created = created;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
public Long getSalaentityId(){
        return this.salaentityId;
}
public void setSalaentityId(Long salaentityId){
        this.salaentityId=salaentityId;
}
public Long getSobaentityId(Long sobaentityId){
        return this.sobaentityId;
}
public void setSobaentityId(Long sobaentityId){
        this.sobaentityId=sobaentityId;
}
    public Rezervacija(){ }
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
