package com.coderbyte.apprickmorty.infrastructure.controllers;

import com.coderbyte.apprickmorty.application.services.AnimatedCharacterService;
import com.coderbyte.apprickmorty.domian.models.AnimatedCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/animatedcharacter")
public class AnimatedCharacterController {

    private AnimatedCharacterService animatedCharacterService;
//    private AnimatedPreconditionService animatedPreconditionService;

//    @Autowired
//    public AnimatedCharacterController(AnimatedCharacterService animatedCharacterService, AnimatedPreconditionService animatedPreconditionService) {
//        this.animatedCharacterService = animatedCharacterService;
//        this.animatedPreconditionService = animatedPreconditionService;
//    }


    public AnimatedCharacterController(AnimatedCharacterService animatedCharacterService) {
        this.animatedCharacterService = animatedCharacterService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAll(@RequestParam(name = "order", defaultValue = "0") String order) {
//        animatedPreconditionService.checkOrderBy(order);
        List<AnimatedCharacter> animatedCharacterList = animatedCharacterService.getAllAnimatedCharacters(Integer.parseInt(order));
        return ResponseEntity.ok(animatedCharacterList);
    }

    @PostMapping
    public ResponseEntity<Object> postAnimatedCharacter(@RequestBody AnimatedCharacter character) {
//        animatedPreconditionService.checkNullBodyField(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(animatedCharacterService.createAnimatedCharacter(character));
    }

//    @GetMapping(path = "/all/pageable")
//    public ResponseEntity<Object> findByName(
//            @RequestParam(name = "initPage") String initPage,
//            @RequestParam(name = "sizePage") String sizePage,
//            @RequestParam(name = "order", defaultValue = "0") String order
//    ) {
////        animatedPreconditionService.checkOrderBy(order);
////        animatedPreconditionService.checkInitPageBy(initPage);
////        animatedPreconditionService.checkSizePageBy(sizePage);
//
//        PageableSearchDTO dto = new PageableSearchDTO();
//        dto.setOrder(Integer.parseInt(order));
//        dto.setInitPage(Integer.parseInt(initPage));
//        dto.setSizePage(Integer.parseInt(sizePage));
//
//        Page<AnimatedCharacter> characterPage = animatedCharacterService.findAll(dto);
//        return ResponseEntity.ok(AnimatedCharacterMapper.INSTANCE.toPageDto(characterPage));
//    }
}
