package com.coderbyte.apprickmorty.controller;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.controller.mapper.AnimatedCharacterMapper;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/animatedcharacter")
public class AnimatedCharacterController {

    private AnimatedCharacterService animatedCharacterService;

    @Autowired
    public AnimatedCharacterController(AnimatedCharacterService animatedCharacterService) {
        this.animatedCharacterService = animatedCharacterService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAll() {
        List<AnimatedCharacterDTO> animatedCharacterDTOList = animatedCharacterService.getAll().stream().map(AnimatedCharacterMapper.INSTANCE::toDto).toList();
        return ResponseEntity.ok(animatedCharacterDTOList);
    }

    @PostMapping
    public ResponseEntity<Object> postAnimatedCharacter(@RequestBody AnimatedCharacterDTO dto) {
        AnimatedCharacter animatedCharacter = AnimatedCharacterMapper.INSTANCE.toEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(animatedCharacterService.postAnimatedCharacter(animatedCharacter));
    }
}
