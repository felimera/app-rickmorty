package com.coderbyte.apprickmorty.infrastructure.repositories.called;

import com.coderbyte.apprickmorty.builder.entities.CalledTablesDTOBuilder;
import com.coderbyte.apprickmorty.builder.entities.SystemErrorDTOBuilder;
import com.coderbyte.apprickmorty.builder.models.CalledTablesEntityBuilder;
import com.coderbyte.apprickmorty.domian.models.in.CalledTablesEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.TypeRequest;
import com.coderbyte.apprickmorty.infrastructure.util.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class JpaCalledTablesRepositoryAdapterTest {
    @Mock
    JpaCalledTablesRepository jpaCalledTablesRespository;
    @InjectMocks
    JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter;

    CalledTablesEntity calledTablesEntity;
    CalledTablesDTO calledTablesDTO;
    SystemErrorDTO systemErrorDTO;

    @BeforeEach
    void setUp() {
        calledTablesEntity = CalledTablesEntityBuilder.builder().build().toCalledTablesEntity();
        calledTablesDTO = CalledTablesDTOBuilder.builder().build().toCalledTablesDTO();
        systemErrorDTO = SystemErrorDTOBuilder.builder().build().toSystemErrorDTO();
    }

    @DisplayName("Test JUnit to Save without errors.")
    @Test
    void when_it_is_successfully_registered_in_the_database() {
        given(jpaCalledTablesRespository.save(any())).willReturn(calledTablesEntity);
        CalledTablesDTO tables = jpaCalledTablesRepositoryAdapter.save(calledTablesDTO);
        assertThat(tables).isNotNull();
    }

    @DisplayName("Test JUnit to the Save with error.")
    @Test
    void when_it_is_successfully_recorded_in_both_tables() {
        given(jpaCalledTablesRespository.save(any())).willReturn(calledTablesEntity);
        CalledTablesDTO tables = jpaCalledTablesRepositoryAdapter.saveWithError(calledTablesDTO, systemErrorDTO);
        assertThat(tables).isNotNull();
    }

    @DisplayName("Test JUnit to the AddCalledTables.")
    @Test
    void when_data_is_mapped_correctly() {
        CalledTablesDTO tables = jpaCalledTablesRepositoryAdapter.addCalledTables(Constantes.PARAMETER, calledTablesDTO, TypeRequest.POST.name());
        assertThat(tables).isNotNull();
    }
}