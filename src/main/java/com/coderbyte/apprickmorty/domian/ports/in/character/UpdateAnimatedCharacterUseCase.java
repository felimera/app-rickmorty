package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;

import java.util.Optional;

public interface UpdateAnimatedCharacterUseCase {
    Optional<AnimatedCharacter> updateAnimatedCharacter(Long id, AnimatedCharacter animatedCharacter);
}
