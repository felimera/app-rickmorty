package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.domian.ports.in.character.CreateAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAnimatedCharacterUserCaseImpl implements CreateAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public AnimatedCharacterDTO createAnimatedCharacter(AnimatedCharacterDTO animatedCharacterDTO) {
        return animatedCharacterRepositoryPort.save(animatedCharacterDTO);
    }
}
