package com.example.hotel.ena.models;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Clob;

@Entity
@Table(name = "salaentity")
public class SalaEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToOne (targetEntity = RezervacijaEntity.class)
    @Column(name = "id")
    private Long id;




    @Column
    private Long numberOfPeople;

    @Column
    private Boolean busy;

    public SalaEntity(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Boolean getBusy(){ return this.busy;}
    public void setBusy(Boolean busy){
        this.busy=busy;
    }

}
