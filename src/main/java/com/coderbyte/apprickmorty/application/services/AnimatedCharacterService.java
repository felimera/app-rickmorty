package com.coderbyte.apprickmorty.application.services;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;
import com.coderbyte.apprickmorty.domian.ports.in.character.CreateAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.in.character.DeleteAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.in.character.RetrieveAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.in.character.UpdateAnimatedCharacterUseCase;

import java.util.List;
import java.util.Optional;

public class AnimatedCharacterService implements CreateAnimatedCharacterUseCase, RetrieveAnimatedCharacterUseCase, UpdateAnimatedCharacterUseCase, DeleteAnimatedCharacterUseCase {
    private final CreateAnimatedCharacterUseCase createAnimatedCharacterUseCase;
    private final RetrieveAnimatedCharacterUseCase retrieveAnimatedCharacterUseCase;
    private final UpdateAnimatedCharacterUseCase updateAnimatedCharacterUseCase;
    private final DeleteAnimatedCharacterUseCase deleteAnimatedCharacterUseCase;

    public AnimatedCharacterService(CreateAnimatedCharacterUseCase createAnimatedCharacterUseCase, RetrieveAnimatedCharacterUseCase retrieveAnimatedCharacterUseCase, UpdateAnimatedCharacterUseCase updateAnimatedCharacterUseCase, DeleteAnimatedCharacterUseCase deleteAnimatedCharacterUseCase) {
        this.createAnimatedCharacterUseCase = createAnimatedCharacterUseCase;
        this.retrieveAnimatedCharacterUseCase = retrieveAnimatedCharacterUseCase;
        this.updateAnimatedCharacterUseCase = updateAnimatedCharacterUseCase;
        this.deleteAnimatedCharacterUseCase = deleteAnimatedCharacterUseCase;
    }

    @Override
    public AnimatedCharacter createAnimatedCharacter(AnimatedCharacter animatedCharacter) {
        return createAnimatedCharacterUseCase.createAnimatedCharacter(animatedCharacter);
    }

    @Override
    public boolean deleteAnimatedCharacter(Long id) {
        return deleteAnimatedCharacterUseCase.deleteAnimatedCharacter(id);
    }

    @Override
    public Optional<AnimatedCharacter> getAnimatedCharacter(Long id) {
        return retrieveAnimatedCharacterUseCase.getAnimatedCharacter(id);
    }

    @Override
    public List<AnimatedCharacter> getAllAnimatedCharacters(Integer order) {
        return retrieveAnimatedCharacterUseCase.getAllAnimatedCharacters(order);
    }

    @Override
    public Optional<AnimatedCharacter> updateAnimatedCharacter(Long id, AnimatedCharacter animatedCharacter) {
        return updateAnimatedCharacterUseCase.updateAnimatedCharacter(id,animatedCharacter);
    }
}
