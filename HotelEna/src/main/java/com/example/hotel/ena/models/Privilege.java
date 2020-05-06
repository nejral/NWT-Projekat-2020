package com.example.hotel.ena.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Privilege {
    @Id
    @GeneratedValue
    private Long privilegeId;
    private String name;
    private String description;
}