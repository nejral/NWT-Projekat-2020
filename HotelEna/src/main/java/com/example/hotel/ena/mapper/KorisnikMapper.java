package com.example.hotel.ena.mapper;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.KorisnikEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy  = ReportingPolicy.IGNORE,componentModel = "spring")
public interface KorisnikMapper {
    @Mappings({
            @Mapping(target="name", source="name"),
            @Mapping(target="username", source="username")
    })
   KorisnikEntity dtoToEntity(KorisnikRequest korisnik);


        Korisnik entityToDto(KorisnikEntity korisnikEntity);

        @InheritConfiguration
        void updateDto(KorisnikEntity korisnikEntity, @MappingTarget Korisnik korisnik);

        @InheritConfiguration
        void updateEntity(Korisnik korisnik, @MappingTarget KorisnikEntity korisnikEntity);

        List<KorisnikEntity> dtosToEntities(List<Korisnik> korisnik);

        List<Korisnik> entitiesToDtos(List<KorisnikEntity> korisnikEntity);
    }

