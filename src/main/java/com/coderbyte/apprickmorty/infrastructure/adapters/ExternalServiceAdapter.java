package com.coderbyte.apprickmorty.infrastructure.adapters;

import com.coderbyte.apprickmorty.domian.models.response.CharacterAllResponse;
import com.coderbyte.apprickmorty.domian.models.response.CharacterSchema;
import com.coderbyte.apprickmorty.domian.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class ExternalServiceAdapter implements ExternalServicePort {
    private final RestTemplate restTemplate;
    private Logger logger = Logger.getLogger(getClass().getName());

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CharacterSchema> getCharacterSchemaInfor(String name) {
        try {
            String apiUrl = "https://rickandmortyapi.com/api/character/?name=" + name;
            ResponseEntity<CharacterAllResponse> response = restTemplate.getForEntity(apiUrl, CharacterAllResponse.class);
            if (Objects.nonNull(response.getBody())) {
                CharacterAllResponse allSchema = response.getBody();
                if (Objects.nonNull(allSchema))
                    return allSchema.getResults();
            }
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
