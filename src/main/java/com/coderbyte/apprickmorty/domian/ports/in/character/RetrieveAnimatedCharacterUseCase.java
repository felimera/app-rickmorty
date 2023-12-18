package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;

import java.util.List;
import java.util.Optional;

public interface RetrieveAnimatedCharacterUseCase {
    Optional<AnimatedCharacterDTO> getAnimatedCharacter(Long id);

    List<AnimatedCharacterDTO> getAllAnimatedCharacters(Integer order);
}
