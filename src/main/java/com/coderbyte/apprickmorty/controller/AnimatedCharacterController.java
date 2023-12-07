package com.coderbyte.apprickmorty.controller;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.controller.mapper.AnimatedCharacterMapper;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/animatedcharacter")
public class AnimatedCharacterController {

    private AnimatedCharacterService animatedCharacterService;

    public AnimatedCharacterController(AnimatedCharacterService animatedCharacterService) {
        this.animatedCharacterService = animatedCharacterService;
    }

    @Autowired


    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAll() {
        List<AnimatedCharacterDTO>animatedCharacterDTOList=animatedCharacterService.getAll().stream().map(data-> AnimatedCharacterMapper.INSTANCE.toDto(data)).toList();
        return ResponseEntity.ok(animatedCharacterDTOList);
    }
}
