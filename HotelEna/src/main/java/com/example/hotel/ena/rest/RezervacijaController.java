package com.example.hotel.ena.rest;

import com.example.hotel.ena.models.RezervacijaEntity;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.repository.RezervacijaRepository;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija")
class RezervacijakController {
    private RezervacijaRepository rezervacijaRepository;
    private RequestValidation requestValidation;

    @PostMapping()
    public String create(@RequestBody Rezervacija rezervacija) {
        if (requestValidation.validateUser_id(rezervacija.getUser_id()) == null) {
            RezervacijaEntity rezervacijaEntity = new RezervacijaEntity();
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity);
            rezervacijaRepository.save(rezervacijaEntity);
            return "Successfully created!";
        }

        return requestValidation.validateUser_id(rezervacija.getUser_id());

    }

    @GetMapping("/all")
    List<RezervacijaEntity> all() {
        return rezervacijaRepository.findAll();
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
