package com.coderbyte.apprickmorty.builder.models.in;

import com.coderbyte.apprickmorty.domian.models.in.AnimatedCharacterEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimatedCharacterEntityBuilder {
    private Integer id;
    private String name;
    private String picture;
    private String gender;
    private String state;

    private AnimatedCharacterEntityBuilder toAnimatedCharacterEntityBuilder() {
        return AnimatedCharacterEntityBuilder.builder()
                .id(1)
                .name("Rick Sanchez")
                .picture("https://rickandmortyapi.com/api/character/avatar/631.jpeg")
                .gender("Male")
                .state("Alive")
                .build();
    }

    public AnimatedCharacterEntity toAnimatedCharactertEntity() {
        AnimatedCharacterEntityBuilder builder = toAnimatedCharacterEntityBuilder();
        return new AnimatedCharacterEntity(builder.id, builder.name, builder.picture, builder.gender, builder.state);
    }

    public AnimatedCharacterEntity toEditId(Integer id) {
        AnimatedCharacterEntityBuilder builder = toAnimatedCharacterEntityBuilder();
        return new AnimatedCharacterEntity(id, builder.name, builder.picture, builder.gender, builder.state);
    }
}
