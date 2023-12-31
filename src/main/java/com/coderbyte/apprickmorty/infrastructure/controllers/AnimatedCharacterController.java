package com.coderbyte.apprickmorty.infrastructure.controllers;

import com.coderbyte.apprickmorty.application.services.AnimatedCharacterService;
import com.coderbyte.apprickmorty.application.services.AnimatedPreconditionService;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.parameter.PageableSearchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/animatedcharacter")
public class AnimatedCharacterController {

    private AnimatedCharacterService animatedCharacterService;
    private AnimatedPreconditionService animatedPreconditionService;

    public AnimatedCharacterController(AnimatedCharacterService animatedCharacterService, AnimatedPreconditionService animatedPreconditionService) {
        this.animatedCharacterService = animatedCharacterService;
        this.animatedPreconditionService = animatedPreconditionService;
    }


    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAll(@RequestParam(name = "order", defaultValue = "0") String order) {
        animatedPreconditionService.checkOrderBy(order);
        List<AnimatedCharacterDTO> animatedCharacterDTOList = animatedCharacterService.getAllAnimatedCharacters(Integer.parseInt(order));
        return ResponseEntity.ok(animatedCharacterDTOList);
    }

    @PostMapping
    public ResponseEntity<Object> postAnimatedCharacter(@RequestBody AnimatedCharacterDTO character) {
        animatedPreconditionService.checkNullBodyField(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(animatedCharacterService.createAnimatedCharacter(character));
    }

    @GetMapping(path = "/all/pageable")
    public ResponseEntity<Object> findByName(
            @RequestParam(name = "initPage") String initPage,
            @RequestParam(name = "sizePage") String sizePage,
            @RequestParam(name = "order", defaultValue = "0") String order
    ) {
        animatedPreconditionService.checkOrderBy(order);
        animatedPreconditionService.checkInitPageBy(initPage);
        animatedPreconditionService.checkSizePageBy(sizePage);

        PageableSearchDTO dto = new PageableSearchDTO();
        dto.setOrder(Integer.parseInt(order));
        dto.setInitPage(Integer.parseInt(initPage));
        dto.setSizePage(Integer.parseInt(sizePage));

        return ResponseEntity.ok(animatedCharacterService.getDtoPage(dto));
    }
}
