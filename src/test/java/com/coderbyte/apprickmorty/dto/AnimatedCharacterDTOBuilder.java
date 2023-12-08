package com.coderbyte.apprickmorty.dto;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimatedCharacterDTOBuilder {
    private Integer id;
    private String name;
    private String image;
    private String gender;
    private String status;

    private AnimatedCharacterDTOBuilder toAnimatedCharacterDTOBuilder() {
        return AnimatedCharacterDTOBuilder.builder()
                .id(1)
                .name("Rick Sanchez")
                .image("https://rickandmortyapi.com/api/character/avatar/631.jpeg")
                .gender("Male")
                .status("Alive")
                .build();
    }

    public AnimatedCharacterDTO toAnimatedCharacteDTO() {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.image, builder.gender, builder.status);
    }

    public AnimatedCharacterDTO toEditName(String name) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, name, builder.image, builder.gender, builder.status);
    }

    public AnimatedCharacterDTO toEditImage(String image) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, image, builder.gender, builder.status);
    }

    public AnimatedCharacterDTO toEditGender(String gender) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.image, gender, builder.status);
    }

    public AnimatedCharacterDTO toEditStatus(String status) {
        AnimatedCharacterDTOBuilder builder = toAnimatedCharacterDTOBuilder();
        return new AnimatedCharacterDTO(builder.id, builder.name, builder.image, builder.gender, status);
    }
}