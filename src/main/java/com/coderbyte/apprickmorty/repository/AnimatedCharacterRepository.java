package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatedCharacterRepository extends JpaRepository<AnimatedCharacter, Integer>, PagingAndSortingRepository<AnimatedCharacter, Integer>, QueryByExampleExecutor<AnimatedCharacter> {

    @Query("select count(ac.id)>0 from AnimatedCharacter ac where upper(ac.name) = :name")
    Boolean isExistByName(String name);

    Page<AnimatedCharacter> findAll(Pageable pageable);
}
