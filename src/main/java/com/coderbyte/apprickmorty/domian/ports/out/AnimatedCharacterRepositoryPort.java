package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;

import java.util.List;
import java.util.Optional;

public interface AnimatedCharacterRepositoryPort {
    AnimatedCharacter save(AnimatedCharacter animatedCharacter);

    Optional<AnimatedCharacter> findById(Long id);

    List<AnimatedCharacter> findAll(Integer order);

    Optional<AnimatedCharacter> update(Long id, AnimatedCharacter animatedCharacter);

    boolean deleteById(Long id);
}
