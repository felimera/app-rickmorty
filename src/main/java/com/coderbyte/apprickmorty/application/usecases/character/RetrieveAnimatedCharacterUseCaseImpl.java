package com.coderbyte.apprickmorty.application.usecases.character;

import com.coderbyte.apprickmorty.domian.ports.in.character.RetrieveAnimatedCharacterUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.pages.AnimatedCharacterPageDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.parameter.PageableSearchDTO;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveAnimatedCharacterUseCaseImpl implements RetrieveAnimatedCharacterUseCase {

    private final AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort;

    @Override
    public Optional<AnimatedCharacterDTO> getAnimatedCharacter(Long id) {
        return animatedCharacterRepositoryPort.findById(id);
    }

    @Override
    public List<AnimatedCharacterDTO> getAllAnimatedCharacters(Integer order) {
        return animatedCharacterRepositoryPort.findAll(order);
    }

    @Override
    public AnimatedCharacterPageDTO getDtoPage(PageableSearchDTO dto) {
        return animatedCharacterRepositoryPort.getDtoPage(dto);
    }
}
