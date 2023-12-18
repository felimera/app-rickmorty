package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;
import com.coderbyte.apprickmorty.domian.ports.in.character.RetrieveAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveAnimatedCharacterUseCaseImpl implements RetrieveAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public Optional<AnimatedCharacter> getAnimatedCharacter(Long id) {
        return animatedCharacterRepositoryPort.findById(id);
    }

    @Override
    public List<AnimatedCharacter> getAllAnimatedCharacters(Integer order) {
        return animatedCharacterRepositoryPort.findAll(order);
    }
}
