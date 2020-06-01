package com.example.hotel.configuration;


import com.example.hotel.models.*;
import com.example.hotel.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;


@Component

public class AddUsers {

    @Autowired
    private UserRepository userRepository;

    @EventListener

    public void add(ApplicationReadyEvent event) {

        addGuests();
        addEmployees();

    }


    private void addGuests() {

        UserEntity guest = new UserEntity();
        guest.setName("Amina");
        guest.setSurname("Fajic");
        guest.setRole("USER");
        guest.setProvider(AuthProvider.google);
        guest.setEmail("aminafajic879@gmail.com");
        guest.setPassword("something");
        userRepository.save(guest);
    }

    private void addEmployees() {
        UserEntity employee = new UserEntity();
        employee.setName("Nejra");
        employee.setSurname("Lacevic");
        employee.setProvider(AuthProvider.google);
        employee.setPassword("something2");
        userRepository.save(employee);
    }
}
