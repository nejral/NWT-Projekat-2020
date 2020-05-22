package com.example.hotel.repository;

import com.example.hotel.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Long> {


    Optional<KorisnikEntity> findByEmail(String email);

    Boolean existsByEmail(String email);


}
