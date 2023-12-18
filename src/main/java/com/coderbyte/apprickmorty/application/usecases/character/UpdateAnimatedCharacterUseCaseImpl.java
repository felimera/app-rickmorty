package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.domian.ports.in.character.UpdateAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateAnimatedCharacterUseCaseImpl implements UpdateAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public Optional<AnimatedCharacterDTO> updateAnimatedCharacter(Long id, AnimatedCharacterDTO animatedCharacterDTO) {
        return animatedCharacterRepositoryPort.update(id, animatedCharacterDTO);
    }
}
