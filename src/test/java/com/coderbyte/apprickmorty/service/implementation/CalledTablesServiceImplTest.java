package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.entity.CalledTablesBuilder;
import com.coderbyte.apprickmorty.entity.SystemErrorBuilder;
import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.model.TypeRequest;
import com.coderbyte.apprickmorty.repository.CalledTablesRepository;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import com.coderbyte.apprickmorty.utils.Constants;
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
class CalledTablesServiceImplTest {
    @Mock
    private CalledTablesRepository calledTablesRepository;
    @Mock
    private SystemErrorService systemErrorService;

    @InjectMocks
    private CalledTablesServiceImpl calledTablesServiceImpl;

    CalledTables calledTables;
    SystemError systemError;

    @BeforeEach
    void setUp() {
        calledTables = CalledTablesBuilder.builder().build().toCalledTables();
        systemError = SystemErrorBuilder.builder().build().toSystemError();
    }

    @DisplayName("Test JUnit to Post without errors.")
    @Test
    void when_it_is_successfully_registered_in_the_database() {
        given(calledTablesRepository.save(any())).willReturn(calledTables);
        CalledTables tables = calledTablesServiceImpl.postCalledTables(calledTables);
        assertThat(tables).isNotNull();
    }

    @DisplayName("Test JUnit to the Post with error.")
    @Test
    void when_it_is_successfully_recorded_in_both_tables() {
        given(systemErrorService.postSystemError(any())).willReturn(systemError);
        given(calledTablesRepository.save(any())).willReturn(calledTables);
        CalledTables tables = calledTablesServiceImpl.postCalledTablesWithError(calledTables, systemError);
        assertThat(tables).isNotNull();
    }

    @Test
    void when_data_is_mapped_correctly() {
        CalledTables tables = calledTablesServiceImpl.addCalledTables(Constants.PARAMETER, calledTables, TypeRequest.POST.name());
        assertThat(tables).isNotNull();
    }
}