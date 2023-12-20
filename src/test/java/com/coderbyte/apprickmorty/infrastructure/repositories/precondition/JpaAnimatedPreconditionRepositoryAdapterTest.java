package com.coderbyte.apprickmorty.infrastructure.repositories.precondition;

import com.coderbyte.apprickmorty.builder.entities.AnimatedCharacterDTOBuilder;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.exception.BusinessException;
import com.coderbyte.apprickmorty.infrastructure.repositories.called.JpaCalledTablesRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.system.JpaSystemErrorRepositoryAdapter;
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
class JpaAnimatedPreconditionRepositoryAdapterTest {
    @Mock
    JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter;
    @Mock
    JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter;
    @InjectMocks
    JpaAnimatedPreconditionRepositoryAdapter jpaAnimatedPreconditionRepositoryAdapter;

    @DisplayName("Test Junit to validate the CheckOrderBy method.")
    @Test
    void when_the_order_is_not_a_number() {
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkOrderBy("A"));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_name_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditName("");
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_name_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditName(null);
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_image_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditPicture("");
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_image_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditPicture(null);
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_gender_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditGender("");
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_gender_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditGender(null);
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_status_attributes_of_the_body_are_not_empty() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditState("");
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate the CheckNullBodyField method.")
    @Test
    void when_it_is_verified_that_the_status_attributes_of_the_body_are_not_null() {
        AnimatedCharacterDTO animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toEditState(null);
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkNullBodyField(animatedCharacterDTO));
    }

    @DisplayName("Test Junit to validate CheckInitPageBy method.")
    @Test
    void when_the_initPage_is_not_a_number() {
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkInitPageBy("A"));
    }

    @DisplayName("Test Junit to validate CheckInitPageBy method.")
    @Test
    void when_the_initPage_is_empty_or_null() {
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkInitPageBy(""));
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkInitPageBy(null));
    }

    @DisplayName("Test Junit to validate CheckSizePageBy method.")
    @Test
    void when_the_sizePage_is_not_a_number() {
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkSizePageBy("A"));
    }

    @DisplayName("Test Junit to validate CheckSizePageBy method.")
    @Test
    void when_the_sizePage_is_empty_or_null() {
        doThrow(BusinessException.class).when(jpaCalledTablesRepositoryAdapter).saveWithError(any(), any());
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkSizePageBy(""));
        assertThrows(BusinessException.class, () -> jpaAnimatedPreconditionRepositoryAdapter.checkSizePageBy(null));
    }
}