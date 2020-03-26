package com.hotel.ena.restservice;

import java.math.BigDecimal;


        import java.util.concurrent.atomic.AtomicLong;

import com.hotel.ena.repository.RezervacijaRepository;
import org.springframework.web.bind.annotation.GetMapping;
        import com.hotel.ena.repository.RezervacijaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class RezervacijaController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private RezervacijaRepository rezervacijaRepozitorij;


    @PostMapping("/rezervacija")

    public Rezervacija rezervacija() {
        return new Rezervacija(counter.incrementAndGet());
    }

    @GetMapping("/rezervacija")

    public ListRezervacija findRezervacija() {
        return rezervacijaRepozitorij.findAll();
    }


}