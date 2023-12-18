package com.coderbyte.apprickmorty.domian.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CharacterAllResponse {
    private Information info;
    private List<CharacterSchema> results;
}
