package com.coderbyte.apprickmorty.infrastructure.repositories.character;

import com.coderbyte.apprickmorty.domian.models.in.AnimatedCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnimatedCharacterRepository extends JpaRepository<AnimatedCharacterEntity, Long> {
}
