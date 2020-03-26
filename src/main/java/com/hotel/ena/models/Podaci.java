package com.hotel.ena.models;


import com.hotel.ena.accessingdatarest.ITAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;


import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.ArrayList;



import java.util.List;

@Component

public class Podaci {

    private ITAdminRepository itadminRepozitorij;


    @Autowired
    public Podaci(ITAdminRepository itadminRepozitorij) {

        this.itadminRepozitorij = itadminRepozitorij;
    }

    @EventListener
    public void dodaj(ApplicationReadyEvent event) {

        dodajITAdmin();
    }


    private void dodajITAdmin() {

        ba.com.zira.template.dao.model.translation.ITAdminEntity itadmin = new ba.com.zira.template.dao.model.translation.ITAdminEntity();

        itadminRepozitorij.save(itadmin);
    }
}

      

