package com.coderbyte.apprickmorty.domian.models.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CharacterSchema {
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
}
