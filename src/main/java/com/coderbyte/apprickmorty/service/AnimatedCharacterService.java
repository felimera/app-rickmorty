package com.coderbyte.apprickmorty.service;

import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimatedCharacterService {
    List<AnimatedCharacter> getAll(int order);

    AnimatedCharacter postAnimatedCharacter(AnimatedCharacter animatedCharacter);

    Page<AnimatedCharacter> findAll(PageableSearchDTO pageableSearchDTO);
}
