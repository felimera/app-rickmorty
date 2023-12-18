package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;

import java.util.Optional;

public interface UpdateAnimatedCharacterUseCase {
    Optional<AnimatedCharacterDTO> updateAnimatedCharacter(Long id, AnimatedCharacterDTO animatedCharacterDTO);
}
