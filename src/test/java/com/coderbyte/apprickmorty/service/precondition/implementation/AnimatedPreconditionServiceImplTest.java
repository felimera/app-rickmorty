package com.coderbyte.apprickmorty.service.precondition.implementation;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.dto.AnimatedCharacterDTOBuilder;
import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import com.coderbyte.apprickmorty.utils.NumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class AnimatedPreconditionServiceImplTest {
    @Mock
    private CalledTablesService calledTablesService;
    @Mock
    private SystemErrorService systemErrorService;
    @Mock
    NumberUtil numberUtil;
    @InjectMocks
    AnimatedPreconditionServiceImpl animatedPreconditionServiceImpl;

    @DisplayName("Test Junit to validate the CheckOrderBy method.")
    @Test
    void when_the_order_is_not_a_number() {
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkOrderBy("A"));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_name_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditName("");
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_name_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditName(null);
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_image_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditImage("");
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_image_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditImage(null);
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_gender_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditGender("");
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_gender_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditGender(null);
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_status_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditStatus("");
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_status_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditStatus(null);
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate CheckInitPageBy method.")
    @Test
    void when_the_initPage_is_not_a_number() {
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkInitPageBy("A"));
    }

    @DisplayName("Test Junit to validate CheckInitPageBy method.")
    @Test
    void when_the_initPage_is_empty_or_null() {
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkInitPageBy(""));
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkInitPageBy(null));
    }

    @DisplayName("Test Junit to validate CheckSizePageBy method.")
    @Test
    void when_the_sizePage_is_not_a_number() {
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkSizePageBy("A"));
    }

    @DisplayName("Test Junit to validate CheckSizePageBy method.")
    @Test
    void when_the_sizePage_is_empty_or_null() {
        doThrow(BusinessException.class).when(calledTablesService).postCalledTablesWithError(any(), any());
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkSizePageBy(""));
        assertThrows(BusinessException.class, () -> animatedPreconditionServiceImpl.checkSizePageBy(null));
    }
}