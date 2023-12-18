package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.infrastructure.entities.response.CharacterSchema;

public interface ExternalServicePort {
    CharacterSchema getCharacterSchemaInfor(String name);
}
