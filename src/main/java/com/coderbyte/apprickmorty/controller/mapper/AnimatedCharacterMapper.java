package com.coderbyte.apprickmorty.controller.mapper;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterPageDTO;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface AnimatedCharacterMapper {

    AnimatedCharacterMapper INSTANCE = Mappers.getMapper(AnimatedCharacterMapper.class);

    @Mapping(target = "image", source = "picture")
    @Mapping(target = "status", source = "state")
    AnimatedCharacterDTO toDto(AnimatedCharacter entity);

    @InheritInverseConfiguration
    AnimatedCharacter toEntity(AnimatedCharacterDTO dto);

    AnimatedCharacterPageDTO toPageDto(Page<AnimatedCharacter> characters);
}
