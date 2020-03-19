package com.hotel.ena.models;

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
@Table(name = "SALA")
@NamedQuery(name = "SalaEntity.findAll", query = "SELECT t FROM SalaEntity t")
public class SobaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SALA_ID_GENERATOR", sequenceName = "SALA_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALA_ID_GENERATOR")
    private Long id;

    private int number_of_people;

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    private Long reservation_id;

    private Long user_id;

    public SobaEntity() {
    }


    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


}