package ba.com.zira.template.dao.model.translation;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "ITAdmin")
@NamedQuery(name = "ITAdminEntity.findAll", query = "SELECT t FROM ITAdminEntity t")
public class ITAdminEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id

    private Long id;

    @SequenceGenerator(name = "ITAdmin_ID_GENERATOR", sequenceName = "ITAdmin_SEQ",
             allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITAdmin_ID_GENERATOR")



   private String name;
    private String surname;
    private String username;
    private String password;


    public ITAdminEntity() { }


}