package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatedCharacterRepository extends JpaRepository<AnimatedCharacter, Integer> {
}
