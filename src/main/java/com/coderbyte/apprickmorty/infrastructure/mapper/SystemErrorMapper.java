package com.coderbyte.apprickmorty.infrastructure.mapper;

import com.coderbyte.apprickmorty.domian.models.SystemErrorEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemErrorMapper {
    SystemErrorMapper INSTANCE = Mappers.getMapper(SystemErrorMapper.class);

    SystemErrorEntity fromDomainModel(SystemErrorDTO dto);

    @InheritInverseConfiguration
    SystemErrorDTO toDomainModel(SystemErrorEntity entity);
}
