package com.coderbyte.apprickmorty.controller;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.controller.mapper.AnimatedCharacterMapper;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Object> getAll(@RequestParam(name = "order", defaultValue = "0") String order) {
        List<AnimatedCharacterDTO> animatedCharacterDTOList = animatedCharacterService.getAll(Integer.parseInt(order)).stream().map(AnimatedCharacterMapper.INSTANCE::toDto).toList();
        return ResponseEntity.ok(animatedCharacterDTOList);
    }

    @PostMapping
    public ResponseEntity<Object> postAnimatedCharacter(@RequestBody AnimatedCharacterDTO dto) {
        AnimatedCharacter animatedCharacter = AnimatedCharacterMapper.INSTANCE.toEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(animatedCharacterService.postAnimatedCharacter(animatedCharacter));
    }

    @GetMapping(path = "/all/pageable")
    public ResponseEntity<Object> findByName(
            @RequestParam(name = "initPage") String initPage,
            @RequestParam(name = "sizePage") String sizePage,
            @RequestParam(name = "order", defaultValue = "0") String order
    ) {
        PageableSearchDTO dto = new PageableSearchDTO();
        dto.setOrder(Integer.parseInt(order));
        dto.setInitPage(Integer.parseInt(initPage));
        dto.setSizePage(Integer.parseInt(sizePage));

        Page<AnimatedCharacter> characterPage = animatedCharacterService.findAll(dto);
        return ResponseEntity.ok(AnimatedCharacterMapper.INSTANCE.toPageDto(characterPage));
    }
}
