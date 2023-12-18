package com.coderbyte.apprickmorty.domian.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimatedCharacter {
    private Integer id;
    private String name;
    private String picture;
    private String gender;
    private String state;
}
