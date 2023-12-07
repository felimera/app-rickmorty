package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimatedCharacterRepository extends JpaRepository<AnimatedCharacter, Integer> {
    @Query("select ac from AnimatedCharacter ac where upper(ac.name) = :name")
    Optional<AnimatedCharacter> findByName(String name);
}
