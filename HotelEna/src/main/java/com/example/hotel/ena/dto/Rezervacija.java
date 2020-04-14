package com.example.hotel.ena.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class Rezervacija implements Serializable {

    @NotNull
    private Long user_id;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date created;
    @NotNull
    private Date validFrom;
    @NotNull
    private Date validTo;

    public Rezervacija(Long user_id, Long createdBy, Date created, Date validFrom, Date validTo) {
        this.user_id = user_id;
        this.createdBy = createdBy;
        this.created = created;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Rezervacija(){ }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

}
