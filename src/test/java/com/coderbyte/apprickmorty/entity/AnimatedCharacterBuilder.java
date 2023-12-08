package com.coderbyte.apprickmorty.entity;

import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimatedCharacterBuilder {
    private Integer id;
    private String name;
    private String picture;
    private String gender;
    private String state;

    private AnimatedCharacterBuilder toAnimatedCharacterBuilder() {
        return AnimatedCharacterBuilder.builder()
                .id(1)
                .name("Rick Sanchez")
                .picture("https://rickandmortyapi.com/api/character/avatar/631.jpeg")
                .gender("Male")
                .state("Alive")
                .build();
    }

    public AnimatedCharacter toAnimatedCharactert() {
        AnimatedCharacterBuilder builder = toAnimatedCharacterBuilder();
        return new AnimatedCharacter(builder.id, builder.name, builder.picture, builder.gender, builder.state);
    }

    public AnimatedCharacter toEditId(Integer id) {
        AnimatedCharacterBuilder builder = toAnimatedCharacterBuilder();
        return new AnimatedCharacter(id, builder.name, builder.picture, builder.gender, builder.state);
    }
}
