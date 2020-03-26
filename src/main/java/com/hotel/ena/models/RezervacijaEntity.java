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
@Table(name = "Rezervacija")
@NamedQuery(name = "RezervacijaEntity.findAll", query = "SELECT t FROM RezervacijaEntity t")
public class RezervacijaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Date getValitTo() {
        return valitTo;
    }

    public void setValitTo(Date valitTo) {
        this.valitTo = valitTo;
    }

    @Id
    @SequenceGenerator(name = "Rezervacija_ID_GENERATOR", sequenceName = "Rezervacija_SEQ",
             allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Rezervacija_ID_GENERATOR")
    private Long id;

   private Long user_id;
   private Long createdBy;
   private Date created;

    private Date validFrom;
    private Date valitTo;

    /// drugi kljucevi

    public RezervacijaEntity() {
    }



   

}