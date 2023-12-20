package com.coderbyte.apprickmorty.builder.models;

import com.coderbyte.apprickmorty.domian.models.out.CharacterSchema;
import com.coderbyte.apprickmorty.domian.models.out.Ubication;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class CharacterSchemaBuilder {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Ubication origin;
    private Ubication location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    private CharacterSchemaBuilder toCharacterSchemaBuilder() {
        return CharacterSchemaBuilder.builder()
                .id(1)
                .name("Rick Sanchez")
                .status("Alive")
                .species("Human")
                .type("")
                .gender("Male")
                .origin(null)
                .location(null)
                .image("https://rickandmortyapi.com/api/character/avatar/631.jpeg")
                .gender("Male")
                .episode(Arrays.asList("https://rickandmortyapi.com/api/episode/1", "https://rickandmortyapi.com/api/episode/2"))
                .url("https://rickandmortyapi.com/api/character/1")
                .created("2017-11-04T18:48:46.250Z")
                .build();
    }

    public CharacterSchema toCharacterSchema() {
        CharacterSchemaBuilder builder = toCharacterSchemaBuilder();
        return new CharacterSchema(builder.id, builder.name, builder.status, builder.species, builder.type, builder.gender, builder.origin, builder.location, builder.image, builder.episode, builder.url, builder.created);
    }
}
