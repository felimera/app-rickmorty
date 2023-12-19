package com.coderbyte.apprickmorty.infrastructure.mapper;

import com.coderbyte.apprickmorty.domian.models.in.CalledTablesEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalledTableMapper {
    CalledTableMapper INSTANCE = Mappers.getMapper(CalledTableMapper.class);

    CalledTablesEntity fromDomainModel(CalledTablesDTO dto);

    @InheritInverseConfiguration
    CalledTablesDTO toDomainModel(CalledTablesEntity entity);
}
