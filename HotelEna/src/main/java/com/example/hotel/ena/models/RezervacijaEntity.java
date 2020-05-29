package com.example.hotel.ena.models;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.*;
import java.util.Date;

@Entity
@AllArgsConstructor
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
    private LocalDate created;
    @Column
    private LocalDate validFrom;
    @Column
    private LocalDate validTo;

@Column
private Long racunId;
@Column
private Boolean done;
public Long getRacunId(){ return racunId;}


public void setRacunId(Long racunId) { this.racunId=racunId;}

public Boolean getDone() { return this.done;}
public void setDone(Boolean done){
    this.done=done;
}

public Long getSalaentityId(){ return  this.salaentityId;}
public void setSalaentityId(Long salaentityId){ this.salaentityId=salaentityId;}
    private Long salaentityId;



    private Long sobaentityId;
    public Long getSobaentityId(){ return  this.sobaentityId;}
    public void setSobaentityId(Long sobaentityId){ this.sobaentityId=sobaentityId;}


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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
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




    public RezervacijaEntity() {
    }

}
