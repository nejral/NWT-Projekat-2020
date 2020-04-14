package com.example.hotel.ena.mapper;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.RacunEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy  = ReportingPolicy.IGNORE,componentModel = "spring")
public interface RacunMapper {
    @Mappings({
          //  @Mapping(target="reservationId", source="reservationId"),
            @Mapping(target="cost", source="cost")
    })
    RacunEntity dtoToEntity(RacunRequest racun);


    Racun entityToDto(RacunEntity racunEntity);

    @InheritConfiguration
    void updateDto(RacunEntity racunEntity, @MappingTarget Racun racun );

    @InheritConfiguration
    void updateEntity(Racun racun , @MappingTarget RacunEntity racunEntity );

    List<RacunEntity> dtosToEntities(List<Racun> racun);

    List<Racun> entitiesToDtos(List<RacunEntity> racunEntity);
}

