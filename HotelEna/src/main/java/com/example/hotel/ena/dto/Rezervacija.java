package com.example.hotel.ena.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
public class Rezervacija implements Serializable {

    @NotNull
    private Long userId;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date created;
    @NotNull
    private Date validFrom;
    @NotNull
    private Date validTo;

    public Rezervacija(Long user_id, Long createdBy, Date created, Date validFrom, Date validTo) {
        this.userId = user_id;
        this.createdBy = createdBy;
        this.created = created;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Rezervacija(){ }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
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
