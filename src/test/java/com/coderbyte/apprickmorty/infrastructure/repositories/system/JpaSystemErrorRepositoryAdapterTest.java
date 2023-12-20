package com.coderbyte.apprickmorty.infrastructure.repositories.system;

import com.coderbyte.apprickmorty.builder.entities.SystemErrorDTOBuilder;
import com.coderbyte.apprickmorty.builder.models.SystemErrorEntityBuilder;
import com.coderbyte.apprickmorty.domian.models.in.SystemErrorEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class JpaSystemErrorRepositoryAdapterTest {
    @Mock
    JpaSystemErrorRepository jpaSystemErrorRepository;
    @InjectMocks
    JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter;

    SystemErrorEntity systemErrorEntity;
    SystemErrorDTO systemErrorDTO;

    @BeforeEach
    void setUp() {
        systemErrorEntity = SystemErrorEntityBuilder.builder().build().toSystemErrorEntity();
        systemErrorDTO = SystemErrorDTOBuilder.builder().build().toSystemErrorDTO();
    }

    @DisplayName("Test Junit for the Save method.")
    @Test
    void when_to_save_successfully() {
        given(jpaSystemErrorRepository.save(any(SystemErrorEntity.class))).willReturn(systemErrorEntity);
        SystemErrorDTO error = jpaSystemErrorRepositoryAdapter.save(systemErrorDTO);
        assertThat(error).isNotNull();
    }

    @DisplayName("Test Junit for class mapper.")
    @Test
    void when_the_assignment_is_done_correctly() {
        SystemErrorDTO error = jpaSystemErrorRepositoryAdapter.addSystemError("401-1", HttpStatus.BAD_REQUEST.name(), "La iformacion no se logra gestionar de forma correcta.");
        assertThat(error).isNotNull();
    }
}