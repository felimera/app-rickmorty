package com.coderbyte.apprickmorty.builder.entities;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimatedCharacterDTOBuilder {
    private Integer id;
    private String name;
    private String picture;
    private String gender;
    private String state;

    private AnimatedCharacterDTOBuilder toAnimatedCharacterDTOBuilder() {
        return AnimatedCharacterDTOBuilder.builder()
                .id(1)
                .name("Rick Sanchez")
                .picture("https://rickandmortyapi.com/api/character/avatar/631.jpeg")
                .gender("Male")
                .state("Alive")
                .build();
    }

    public AnimatedCharacterDTO toAnimatedCharactertDTO() {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.picture, builder.gender, builder.state);
    }

    public AnimatedCharacterDTO toEditId(Integer id) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(id, builder.name, builder.picture, builder.gender, builder.state);
    }
    public AnimatedCharacterDTO toEditName(String name) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, name, builder.picture, builder.gender, builder.state);
    }
    public AnimatedCharacterDTO toEditPicture(String picture) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, picture, builder.gender, builder.state);
    }
    public AnimatedCharacterDTO toEditGender(String gender) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.picture, gender, builder.state);
    }
    public AnimatedCharacterDTO toEditState(String state) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.picture, builder.gender, state);
    }
}
