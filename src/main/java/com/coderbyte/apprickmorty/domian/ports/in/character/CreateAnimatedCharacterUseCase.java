package com.coderbyte.apprickmorty.domian.ports.in.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;

public interface CreateAnimatedCharacterUseCase {
    AnimatedCharacter createAnimatedCharacter(AnimatedCharacter animatedCharacter);
}
