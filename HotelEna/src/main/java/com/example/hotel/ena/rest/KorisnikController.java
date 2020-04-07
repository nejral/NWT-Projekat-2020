package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.repository.KorisnikRepository;
import com.example.hotel.ena.service.KorisnikService;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
    private KorisnikRepository korisnikRepository;
    private RequestValidation requestValidation;
    private KorisnikService korisnikService;

    @PostMapping()
    public String create(@RequestBody Korisnik korisnik) {
        if (requestValidation.validateUsername(korisnik.getUsername()) == null) {
            KorisnikEntity korisnikEntity = new KorisnikEntity();
            BeanUtils.copyProperties(korisnik, korisnikEntity);
            korisnikRepository.save(korisnikEntity);
            return "Successfully created!";
        }

        return requestValidation.validateUsername(korisnik.getUsername());

    }

    @GetMapping("/all")
    List<KorisnikEntity> all() {
        return korisnikRepository.findAll();
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Korisnik korisnik) {
        Optional<KorisnikEntity> korisnikEntity = korisnikRepository.findById(id);
        if (korisnikEntity == null) {
            return "Korisnik with id does not exist!";
        } else {
            BeanUtils.copyProperties(korisnik, korisnikEntity);
            return "Updated successfully!";
        }
    }
    @DeleteMapping("/{id}")
    String deleteKorisnik(@PathVariable Long id) {
        if(requestValidation.validateId(id)!=null)
            return requestValidation.validateId(id);
        korisnikRepository.deleteById(id);
        return "Korisnik is deleted successfully";
    }
    @GetMapping("/{userId}/racun")
    Racun findRacunByUserId(@PathVariable Long userId) {
        return korisnikService.findByUserId(userId);
    }

}
