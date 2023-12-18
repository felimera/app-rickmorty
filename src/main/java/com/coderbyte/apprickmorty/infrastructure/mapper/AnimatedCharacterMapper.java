package com.coderbyte.apprickmorty.infrastructure.mapper;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimatedCharacterMapper {

    AnimatedCharacterMapper INSTANCE = Mappers.getMapper(AnimatedCharacterMapper.class);

    AnimatedCharacterEntity fromDomainModel(AnimatedCharacter animatedCharacter);

    @InheritInverseConfiguration
    AnimatedCharacter toDomainModel(AnimatedCharacterEntity entity);

//    AnimatedCharacterPageDTO toPageDto(Page<AnimatedCharacter> characters);
}
