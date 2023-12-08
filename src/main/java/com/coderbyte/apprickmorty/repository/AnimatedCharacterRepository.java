package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatedCharacterRepository extends JpaRepository<AnimatedCharacter, Integer> {

    @Query("select count(ac.id)>0 from AnimatedCharacter ac where upper(ac.name) = :name")
    Boolean isExistByName(String name);
}
