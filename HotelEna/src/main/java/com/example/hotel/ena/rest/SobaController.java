package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Soba;
import com.example.hotel.ena.models.SobaEntity;
import com.example.hotel.ena.repository.SobaRepository;
import com.example.hotel.ena.validation.RequestValidationSoba;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.console;


@AllArgsConstructor
@RestController
@RequestMapping("/soba")
class SobaController {

    private RequestValidationSoba requestValidation;
    private SobaRepository sobaRepository;


    //// za sobu

    @PostMapping()
    public String createSoba(@RequestBody Soba soba) {

        SobaEntity sobaEntity = new SobaEntity();
        BeanUtils.copyProperties(soba, sobaEntity);
        sobaRepository.save(sobaEntity);
        return "Successfully created!";
    }

    @DeleteMapping("/soba/{id}")
    String deleteSoba(@PathVariable Long id) {
        if(requestValidation.validateId(id) != null)
            return requestValidation.validateId(id);
        sobaRepository.deleteById(id);
        return "Soba is deleted successfully";
    }
    @PutMapping("/{id}")
    String updateSoba(@PathVariable Long id, @RequestBody Soba soba) {
        Optional<SobaEntity> sobaEntity = sobaRepository.findById(id);

        if (sobaEntity == null || requestValidation.validateId(id) != null) {
            return "Soba with id does not exist!";
        } else {
            BeanUtils.copyProperties(soba, sobaEntity);
            return "Updated successfully!";
        }

    }

    @GetMapping("/all")
    List<SobaEntity> all() {
        return sobaRepository.findAll();
    }

}