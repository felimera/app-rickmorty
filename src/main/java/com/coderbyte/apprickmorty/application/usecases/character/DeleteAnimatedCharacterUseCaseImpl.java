package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.domian.ports.in.character.DeleteAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAnimatedCharacterUseCaseImpl implements DeleteAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public boolean deleteAnimatedCharacter(Long id) {
        return animatedCharacterRepositoryPort.deleteById(id);
    }
}
