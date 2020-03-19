package ba.com.zira.template.dao.model.translation;

import java.io.Serializable;
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
@Table(name = "GOST")
@NamedQuery(name = "GostEntity.findAll", query = "SELECT t FROM GostEntity t")
public class GostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "GOST_ID_GENERATOR", sequenceName = "GOST_SEQ",
             allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOST_ID_GENERATOR")
    private Long id;

   private String name;
private String surname;
private Date date_of_birth;
private String username;
private String password;

    public GostEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name){
        this.name = name;
    }

 public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname){
        this.surname = surname;
    }

public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username){
        this.username = username;
    }

public String getPassword() {
        return this.password;
    }

    public void setUsername(final String password){
        this.password = password;
    }

public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void getDateOfBirth(final Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

   

}