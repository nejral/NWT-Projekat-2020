package com.example.hotel.ena.models;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "korisnikentity")
public class KorisnikEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @Column
    private String name;

    @Column
    private String password;

    @Column
    private String surname;
    @Column
    private String username;

    public Boolean getZaposlenikInd() {
        return zaposlenikInd;
    }

    public void setZaposlenikInd(Boolean zaposlenikInd) {
        this.zaposlenikInd = zaposlenikInd;
    }

    @Column
    private Boolean zaposlenikInd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public KorisnikEntity() {
    }

}
