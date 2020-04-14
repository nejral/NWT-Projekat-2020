package com.example.hotel.ena.models;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rezervacijaentity")
public class RezervacijaEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long createdBy;

    @Column
    private Date created;
    @Column
    private Date validFrom;
    @Column
    private Date validTo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salaentity_id", referencedColumnName = "id")
    private SalaEntity salaentity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sobaentity_id", referencedColumnName = "id")
    private SalaEntity sobaentity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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


    public SalaEntity getSalaentity() {
        return salaentity;
    }

    public void setSalaentity(SalaEntity salaentity) {
        this.salaentity = salaentity;
    }

    public SalaEntity getSobaentity() {
        return sobaentity;
    }

    public void setSobaentity(SalaEntity sobaentity) {
        this.sobaentity = sobaentity;
    }

    public RezervacijaEntity() {
    }

}
