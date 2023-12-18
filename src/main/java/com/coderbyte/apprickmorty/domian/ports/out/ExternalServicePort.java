package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.domian.models.response.CharacterSchema;

public interface ExternalServicePort {
    CharacterSchema getCharacterSchemaInfor(String name);
}
