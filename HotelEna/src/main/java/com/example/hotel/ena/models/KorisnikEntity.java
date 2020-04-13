package com.example.hotel.ena.models;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@AllArgsConstructor
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
    @Column
    private Boolean employeeInd;

    public KorisnikEntity(Object o, String name, String surname, String username, Boolean b) {
        this.setName(name);
        this.setPassword(password);
        this.setUsername(username);
        this.setEmployeeInd(b);

    }

    public Long getId() {
        return id;
    }

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

    public Boolean getEmployeeInd() {
        return employeeInd;
    }

    public void setEmployeeInd(Boolean employeeInd) {
        this.employeeInd = employeeInd;
    }
public KorisnikEntity(){

}

}
