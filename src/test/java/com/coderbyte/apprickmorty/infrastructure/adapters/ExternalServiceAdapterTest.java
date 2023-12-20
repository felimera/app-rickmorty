package com.coderbyte.apprickmorty.infrastructure.adapters;

import com.coderbyte.apprickmorty.domian.models.out.CharacterSchema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class ExternalServiceAdapterTest {
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    ExternalServiceAdapter externalServiceAdapter;

    @Test
    void whenTheExternalQueryReturnsResult() {
        List<CharacterSchema> schemas = externalServiceAdapter.getCharacterSchemaInfor("Rick");
        assertFalse(schemas.isEmpty());
    }
}