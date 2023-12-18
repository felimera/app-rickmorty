package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacterDTO;

public interface CreateAnimatedCharacterUseCase {
    AnimatedCharacterDTO createAnimatedCharacter(AnimatedCharacterDTO animatedCharacterDTO);
}
