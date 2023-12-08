package com.coderbyte.apprickmorty.controller.dto;

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
    private String image;
    private String gender;
    private String status;
}
