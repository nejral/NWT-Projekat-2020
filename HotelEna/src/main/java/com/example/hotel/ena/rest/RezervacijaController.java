package com.example.hotel.ena.rest;

import com.example.hotel.ena.models.RezervacijaEntity;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.repository.RezervacijaRepository;
import com.example.hotel.ena.service.RezervacijaService;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija")
class RezervacijaController {
    private RezervacijaRepository rezervacijaRepository;
    private RequestValidation requestValidation;
    private RezervacijaService rezervacijaService;

    @PostMapping()
    public String create(@RequestBody Rezervacija rezervacija) {
        if (requestValidation.validateUserId(rezervacija.getUserId()) == null) {
            RezervacijaEntity rezervacijaEntity = new RezervacijaEntity();
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity);
            rezervacijaRepository.save(rezervacijaEntity);
            return "Successfully created!";
        }

        return requestValidation.validateUserId(rezervacija.getUserId());

    }

    @GetMapping("/all")
    List<RezervacijaEntity> all() {
        return rezervacijaRepository.findAll();
    }

    @GetMapping("/allByUserId/{id}")
    List<Rezervacija> allByUserId(@PathVariable Long id) {
        List<RezervacijaEntity> lista;
        List<RezervacijaEntity> pomLista = new ArrayList<RezervacijaEntity>();
        lista = rezervacijaRepository.findAll();
        for (RezervacijaEntity rez : lista){
            if (rez.getUserId().equals(id))
                pomLista.add(rez);
        }
        List<Rezervacija> rezervacije = new ArrayList();
        BeanUtils.copyProperties( rezervacije, pomLista);

        //System.out.println(rezervacije);
        return rezervacije;
    }

    @GetMapping("/allByCreatedBy/{id}")
    List<Rezervacija> allByCreatedBy(@PathVariable Long id) {
        List<RezervacijaEntity> lista;
        List<RezervacijaEntity> pomLista = new ArrayList<RezervacijaEntity>();
        lista = rezervacijaRepository.findAll();
        for (RezervacijaEntity rez : lista){
            if (!rez.getCreatedBy().equals(id))
                pomLista.add(rez);
        }
        List<Rezervacija> rezervacije = new ArrayList();
        BeanUtils.copyProperties( rezervacije, pomLista);

        //System.out.println(rezervacije);
        return rezervacije;
    }

    @GetMapping("/checkExpired")
    List<Rezervacija> checkExpired() {
        List<RezervacijaEntity> lista = rezervacijaRepository.findAll();
        for (RezervacijaEntity rez : lista){
            if (rez.getValidTo().compareTo(new Date(System.currentTimeMillis())) > 0)
                lista.remove(rez);
        }
        List<Rezervacija> rezervacije = null;
        BeanUtils.copyProperties(rezervacije, lista);
        return rezervacije;
    }


    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Rezervacija rezervacija) {
        Optional<RezervacijaEntity> rezervacijaEntity = rezervacijaRepository.findById(id);

        if (rezervacijaEntity == null) {
            return "Rezervacija with id does not exist!";
        } else {
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity);
            return "Updated successfully!";
        }

    }



    @DeleteMapping("/{id}")
    String deleteRezervacija(@PathVariable Long id) {
        if(requestValidation.validateId(id) != null)
            return requestValidation.validateId(id);
        rezervacijaRepository.deleteById(id);
        return "Rezervacija is deleted successfully";
    }


}
