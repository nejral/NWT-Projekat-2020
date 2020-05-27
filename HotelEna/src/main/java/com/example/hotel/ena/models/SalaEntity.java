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


    @OneToOne(mappedBy = "salaentity")
    private RezervacijaEntity rezervacijaentity;

    @Column
    private int numberOfPeople;

    @Column
    private Long userId;

    public SalaEntity(){}


    public RezervacijaEntity getRezervacijaEntity() {
        return rezervacijaentity;
    }

    public void setRezervacijaEntity(RezervacijaEntity rezervacija) {
        this.rezervacijaentity = rezervacija;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
