package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;
import com.coderbyte.apprickmorty.domian.ports.in.character.UpdateAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateAnimatedCharacterUseCaseImpl implements UpdateAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public Optional<AnimatedCharacter> updateAnimatedCharacter(Long id, AnimatedCharacter animatedCharacter) {
        return animatedCharacterRepositoryPort.update(id, animatedCharacter);
    }
}
