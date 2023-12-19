package com.coderbyte.apprickmorty.infrastructure.mapper;

import com.coderbyte.apprickmorty.domian.models.in.AnimatedCharacterEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.pages.AnimatedCharacterPageDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface AnimatedCharacterMapper {

    AnimatedCharacterMapper INSTANCE = Mappers.getMapper(AnimatedCharacterMapper.class);

    AnimatedCharacterEntity fromDomainModel(AnimatedCharacterDTO animatedCharacterDTO);

    @InheritInverseConfiguration
    AnimatedCharacterDTO toDomainModel(AnimatedCharacterEntity entity);

    AnimatedCharacterPageDTO toPageDto(Page<AnimatedCharacterEntity> characters);
}
