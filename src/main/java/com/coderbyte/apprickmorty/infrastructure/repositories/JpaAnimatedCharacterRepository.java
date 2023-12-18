package com.coderbyte.apprickmorty.infrastructure.repositories;

import com.coderbyte.apprickmorty.domian.models.AnimatedCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnimatedCharacterRepository extends JpaRepository<AnimatedCharacterEntity, Long> {
}
