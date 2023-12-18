package com.coderbyte.apprickmorty.infrastructure.adapters;

import com.coderbyte.apprickmorty.domian.ports.out.ExternalServicePort;
import com.coderbyte.apprickmorty.infrastructure.entities.response.CharacterSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {
    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CharacterSchema getCharacterSchemaInfor(String name) {
        String apiUrl = "https://rickandmortyapi.com/api/character/?name=" + name;
        ResponseEntity<CharacterSchema> responseEntity = restTemplate.getForEntity(apiUrl, CharacterSchema.class);
        CharacterSchema body = responseEntity.getBody();
        if (body == null) {
            return null;
        }
        return body;
    }
}
