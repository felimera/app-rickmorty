package com.coderbyte.apprickmorty.infrastructure.repositories.character;

import com.coderbyte.apprickmorty.builder.entities.AnimatedCharacterDTOBuilder;
import com.coderbyte.apprickmorty.builder.entities.CalledTablesDTOBuilder;
import com.coderbyte.apprickmorty.builder.entities.PageableSearchDTOBuilder;
import com.coderbyte.apprickmorty.builder.models.in.AnimatedCharacterEntityBuilder;
import com.coderbyte.apprickmorty.builder.models.out.CharacterSchemaBuilder;
import com.coderbyte.apprickmorty.domian.models.in.AnimatedCharacterEntity;
import com.coderbyte.apprickmorty.domian.models.out.CharacterSchema;
import com.coderbyte.apprickmorty.domian.ports.out.ExternalServicePort;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.pages.AnimatedCharacterPageDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.infrastructure.exception.BusinessException;
import com.coderbyte.apprickmorty.infrastructure.exception.NotFoundException;
import com.coderbyte.apprickmorty.infrastructure.repositories.called.JpaCalledTablesRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.system.JpaSystemErrorRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class JpaAnimatedCharacterRepositoryAdapterTest {
    @Mock
    JpaAnimatedCharacterRepository jpaAnimatedCharacterRepository;
    @Mock
    ExternalServicePort externalServicePort;
    @Mock
    JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter;
    @Mock
    JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter;

    @InjectMocks
    JpaAnimatedCharacterRepositoryAdapter jpaAnimatedCharacterRepositoryAdapter;

    AnimatedCharacterDTO animatedCharacterDTO;
    AnimatedCharacterEntity animatedCharacterEntity;
    CharacterSchema characterSchema;
    CalledTablesDTO calledTablesDTO;
    PageableSearchDTO pageableSearchDTO;

    @BeforeEach
    void setUp() {
        animatedCharacterDTO = AnimatedCharacterDTOBuilder.builder().build().toAnimatedCharactertDTO();
        animatedCharacterEntity = AnimatedCharacterEntityBuilder.builder().build().toAnimatedCharactertEntity();
        characterSchema = CharacterSchemaBuilder.builder().build().toCharacterSchema();
        calledTablesDTO = CalledTablesDTOBuilder.builder().build().toCalledTablesDTO();
        pageableSearchDTO = PageableSearchDTOBuilder.builder().build().toPageableSearchDTO();
    }

    @DisplayName("Test JUnit for the FindAll method.")
    @Test
    void when_the_query_with_sorting_returns_a_list_of_results() {
        AnimatedCharacterEntity animatedCharacter1 = AnimatedCharacterEntityBuilder.builder().build().toEditId(2);
        given(jpaAnimatedCharacterRepository.findAll(any(Sort.class))).willReturn(Arrays.asList(animatedCharacterEntity, animatedCharacter1));
        List<AnimatedCharacterDTO> animatedCharacterList = jpaAnimatedCharacterRepositoryAdapter.findAll(0);
        assertThat(animatedCharacterList).isNotNull();
        assertFalse(animatedCharacterList.isEmpty());
    }

    @DisplayName("Test JUnit for the FindAll method.")
    @Test
    void when_the_query_with_sorting_returns_a_list_of_results_by_ordes() {
        AnimatedCharacterEntity animatedCharacter1 = AnimatedCharacterEntityBuilder.builder().build().toEditId(2);
        given(jpaAnimatedCharacterRepository.findAll(any(Sort.class))).willReturn(Arrays.asList(animatedCharacterEntity, animatedCharacter1));
        for (int cont = 1; cont < 5; cont++) {
            List<AnimatedCharacterDTO> animatedCharacterList = jpaAnimatedCharacterRepositoryAdapter.findAll(cont);
            assertThat(animatedCharacterList).isNotNull();
            assertFalse(animatedCharacterList.isEmpty());
        }
    }

    @DisplayName("Test JUnit for the FindAll method.")
    @Test
    void when_the_sort_query_returns_nothing() {
        given(jpaAnimatedCharacterRepository.findAll(any(Sort.class))).willReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, () -> jpaAnimatedCharacterRepositoryAdapter.findAll(1));
        verify(jpaAnimatedCharacterRepository, never()).save(any(AnimatedCharacterEntity.class));
    }

    @DisplayName("Test JUnit for the Save method.")
    @Test
    void when_a_record_is_successfully_saved() {
        String name = "Rick Sanchez";
        given(externalServicePort.getCharacterSchemaInfor(name)).willReturn(Collections.emptyList());
        given(jpaAnimatedCharacterRepository.save(any())).willReturn(animatedCharacterEntity);
        AnimatedCharacterDTO character = jpaAnimatedCharacterRepositoryAdapter.save(animatedCharacterDTO);
        assertThat(character).isNotNull();
        assertThat(character.getId()).isNotNull();
    }

    @DisplayName("Test JUnit for the Save method.")
    @Test
    void when_the_name_is_already_in_the_database() {
        String name = "Rick Sanchez";
        given(externalServicePort.getCharacterSchemaInfor(name)).willReturn(Collections.singletonList(characterSchema));
        given(jpaCalledTablesRepositoryAdapter.saveWithError(any(), any())).willReturn(calledTablesDTO);
        assertThrows(BusinessException.class, () -> jpaAnimatedCharacterRepositoryAdapter.save(animatedCharacterDTO));
        verify(jpaAnimatedCharacterRepository, never()).save(any());
    }

    @DisplayName("Test JUnit for the findAll method. - GetPage")
    @Test
    void when_pagination_returns_results() {
        Pageable pageable = PageRequest.of(2, 2, Sort.Direction.ASC, "name");
        given(jpaAnimatedCharacterRepository.findAll(pageable)).willReturn(Page.empty(pageable));
        AnimatedCharacterPageDTO characterPage = jpaAnimatedCharacterRepositoryAdapter.getDtoPage(pageableSearchDTO);
        assertThat(characterPage).isNotNull();
    }
}