package com.welcome.bot.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.welcome.bot.models.AuthProvider;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "rezervacija", uniqueConstraints = {
        //@UniqueConstraint(columnNames = "email")
})
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public Date getValid_to() {
        return valid_to;
    }

    public void setValid_to(Date valid_to) {
        this.valid_to = valid_to;
    }

    private Long created;

    private Long created_by;

    private Date valid_from;

    private Date valid_to;

   
    public Rezervacija() {

    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
