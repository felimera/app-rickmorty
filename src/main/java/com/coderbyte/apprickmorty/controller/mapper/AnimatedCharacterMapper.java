package com.coderbyte.apprickmorty.controller.mapper;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimatedCharacterMapper {
    AnimatedCharacterMapper INSTANCE = Mappers.getMapper(AnimatedCharacterMapper.class);

    @Mapping(source = "name", target = "nombre")
    @Mapping(target = "imagen", source = "picture")
    @Mapping(target = "genero", source = "gender")
    @Mapping(target = "estado", source = "state")
    AnimatedCharacterDTO toDto(AnimatedCharacter entity);

    @InheritInverseConfiguration
    AnimatedCharacter toEntity(AnimatedCharacterDTO dto);
}
