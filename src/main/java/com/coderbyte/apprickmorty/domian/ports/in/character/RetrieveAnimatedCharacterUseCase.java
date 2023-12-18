package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;

import java.util.List;
import java.util.Optional;

public interface RetrieveAnimatedCharacterUseCase {
    Optional<AnimatedCharacter> getAnimatedCharacter(Long id);

    List<AnimatedCharacter> getAllAnimatedCharacters(Integer order);
}
