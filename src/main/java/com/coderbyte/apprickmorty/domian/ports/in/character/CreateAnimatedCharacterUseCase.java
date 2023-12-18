package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;

public interface CreateAnimatedCharacterUseCase {
    AnimatedCharacterDTO createAnimatedCharacter(AnimatedCharacterDTO animatedCharacterDTO);
}
