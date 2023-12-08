package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.entity.SystemErrorBuilder;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.repository.SystemErrorRepository;
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
class SystemErrorServiceImplTest {
    @Mock
    private SystemErrorRepository systemErrorRepository;
    @InjectMocks
    private SystemErrorServiceImpl systemErrorServiceImpl;

    SystemError systemError;

    @BeforeEach
    void setUp() {
        systemError = SystemErrorBuilder.builder().build().toSystemError();
    }

    @DisplayName("Test Junit for the Post method.")
    @Test
    void when_to_save_successfully() {
        given(systemErrorRepository.save(any(SystemError.class))).willReturn(systemError);
        SystemError error = systemErrorServiceImpl.postSystemError(systemError);
        assertThat(error).isNotNull();
    }

    @DisplayName("Test Junit for class mapper.")
    @Test
    void when_the_assignment_is_done_correctly() {
        SystemError error = systemErrorServiceImpl.addSystemError("401-1", HttpStatus.BAD_REQUEST.name(), "La iformacion no se logra gestionar de forma correcta.");
        assertThat(error).isNotNull();
    }
}