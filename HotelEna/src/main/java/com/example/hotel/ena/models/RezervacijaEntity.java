package com.example.hotel.ena.models;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rezervacijaentity")
public class RezervacijaEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long user_id;

    @Column
    private Long createdBy;

    @Column
    private Date created;
    @Column
    private Date validFrom;
    @Column
    private Date validTo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

    public RezervacijaEntity() {
    }

}
