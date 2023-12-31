package com.coderbyte.apprickmorty.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimatedCharacterDTO {
    private Integer id;
    private String name;
    private String picture;
    private String gender;
    private String state;
}
