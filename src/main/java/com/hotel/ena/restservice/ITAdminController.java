package com.hotel.ena.restservice;

import java.math.BigDecimal;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.hotel.ena.accessingdatarest.ITAdmin;
import com.hotel.ena.repository.ITAdminRepository;
import com.hotel.ena.repository.RezervacijaRepository;
import org.springframework.web.bind.annotation.GetMapping;
        import com.hotel.ena.repository.RezervacijaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ITAdminController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ITAdminRepository itadminRepozitorij;


    @PostMapping("/itadmin")

    public ITAdmin itadmin() {
        return new ITAdmin();
    }

    @GetMapping("/itadmin")
//ako ovo ima smisla za admina
    public List<ITAdmin> findRezervacija() {return itadminRepozitorij.findAll();}

}