package com.coderbyte.apprickmorty.controller;

import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(animatedCharacterService.getAll());
    }
}
