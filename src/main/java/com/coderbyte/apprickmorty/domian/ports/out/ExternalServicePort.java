package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.domian.models.response.CharacterSchema;

import java.util.List;

public interface ExternalServicePort {
    List<CharacterSchema> getCharacterSchemaInfor(String name);
}
