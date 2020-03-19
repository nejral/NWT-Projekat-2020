package ba.com.zira.template.dao.model.translation;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Clob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "SOBA")
@NamedQuery(name = "SobaEntity.findAll", query = "SELECT t FROM SobaEntity t")
public class SobaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SOBA_ID_GENERATOR", sequenceName = "SOBA_SEQ",
             allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOBA_ID_GENERATOR")
    private Long id;

    private int number_of_beds;

    private Boolean busy;

    private ArrayList<Clob> slike;

    public SobaEntity() {
    }

    public ArrayList<Clob> getSlike() {
        return slike;
    }

    public void setSlike(ArrayList<Clob> slike) {
        this.slike = slike;
    }



    public int getNumber_of_beds() {
        return number_of_beds;
    }

    public void setNumber_of_beds(int number_of_beds) {
        this.number_of_beds = number_of_beds;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


}