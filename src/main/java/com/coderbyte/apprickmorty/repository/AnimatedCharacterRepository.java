package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Integer, Character> {
}
