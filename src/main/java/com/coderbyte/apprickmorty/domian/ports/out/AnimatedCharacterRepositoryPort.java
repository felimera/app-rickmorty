package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacterDTO;

import java.util.List;
import java.util.Optional;

public interface AnimatedCharacterRepositoryPort {
    AnimatedCharacterDTO save(AnimatedCharacterDTO animatedCharacterDTO);

    Optional<AnimatedCharacterDTO> findById(Long id);

    List<AnimatedCharacterDTO> findAll(Integer order);

    Optional<AnimatedCharacterDTO> update(Long id, AnimatedCharacterDTO animatedCharacterDTO);

    boolean deleteById(Long id);
}
