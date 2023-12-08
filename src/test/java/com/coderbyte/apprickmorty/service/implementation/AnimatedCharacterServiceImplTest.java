package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.dto.PageableSearchDTOBuilder;
import com.coderbyte.apprickmorty.entity.AnimatedCharacterBuilder;
import com.coderbyte.apprickmorty.entity.CalledTablesBuilder;
import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.repository.AnimatedCharacterRepository;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.service.SystemErrorService;
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
class AnimatedCharacterServiceImplTest {
    @Mock
    private AnimatedCharacterRepository animatedCharacterRepository;
    @Mock
    private CalledTablesService calledTablesService;
    @Mock
    private SystemErrorService systemErrorService;

    @InjectMocks
    AnimatedCharacterServiceImpl animatedCharacterServiceImpl;

    AnimatedCharacter animatedCharacter;
    CalledTables calledTables;
    PageableSearchDTO pageableSearchDTO;

    @BeforeEach
    void setUp() {
        animatedCharacter = AnimatedCharacterBuilder.builder().build().toAnimatedCharactert();
        calledTables = CalledTablesBuilder.builder().build().toCalledTables();
        pageableSearchDTO = PageableSearchDTOBuilder.builder().build().toPageableSearchDTO();
    }

    @DisplayName("Test JUnit for the GetAll method.")
    @Test
    void when_the_query_with_sorting_returns_a_list_of_results() {
        AnimatedCharacter animatedCharacter1 = AnimatedCharacterBuilder.builder().build().toEditId(2);
        given(animatedCharacterRepository.findAll(any(Sort.class))).willReturn(Arrays.asList(animatedCharacter, animatedCharacter1));
        List<AnimatedCharacter> animatedCharacterList = animatedCharacterServiceImpl.getAll(0);
        assertThat(animatedCharacterList).isNotNull();
        assertFalse(animatedCharacterList.isEmpty());
    }

    @DisplayName("Test JUnit for the GetAll method.")
    @Test
    void when_the_query_with_sorting_returns_a_list_of_results_by_ordes() {
        AnimatedCharacter animatedCharacter1 = AnimatedCharacterBuilder.builder().build().toEditId(2);
        given(animatedCharacterRepository.findAll(any(Sort.class))).willReturn(Arrays.asList(animatedCharacter, animatedCharacter1));
        for (int cont = 1; cont < 5; cont++) {
            List<AnimatedCharacter> animatedCharacterList = animatedCharacterServiceImpl.getAll(cont);
            assertThat(animatedCharacterList).isNotNull();
            assertFalse(animatedCharacterList.isEmpty());
        }
    }

    @DisplayName("Test JUnit for the GetAll method.")
    @Test
    void when_the_sort_query_returns_nothing() {
        given(animatedCharacterRepository.findAll(any(Sort.class))).willReturn(Collections.emptyList());
        assertThrows(BusinessException.class, () -> animatedCharacterServiceImpl.getAll(1));
        verify(animatedCharacterRepository, never()).save(any(AnimatedCharacter.class));
    }

    @DisplayName("Test JUnit for the Post method.")
    @Test
    void when_a_record_is_successfully_saved() {
        String name = "Rick Sanchez";
        given(animatedCharacterRepository.isExistByName(name.toUpperCase())).willReturn(Boolean.FALSE);
        given(animatedCharacterRepository.save(any())).willReturn(animatedCharacter);
        AnimatedCharacter character = animatedCharacterServiceImpl.postAnimatedCharacter(animatedCharacter);
        assertThat(character).isNotNull();
        assertThat(character.getId()).isNotNull();
    }

    @DisplayName("Test JUnit for the Post method.")
    @Test
    void when_the_name_is_already_in_the_database() {
        String name = "Rick Sanchez";
        given(animatedCharacterRepository.isExistByName(name.toUpperCase())).willReturn(Boolean.TRUE);
        given(calledTablesService.postCalledTablesWithError(any(), any())).willReturn(calledTables);
        assertThrows(BusinessException.class, () -> animatedCharacterServiceImpl.postAnimatedCharacter(animatedCharacter));
        verify(animatedCharacterRepository, never()).save(any(AnimatedCharacter.class));
    }

    @DisplayName("Test JUnit for the findAll method. - GetPage")
    @Test
    void when_pagination_returns_results() {
        Pageable pageable = PageRequest.of(2, 2, Sort.Direction.ASC, "name");
        given(animatedCharacterRepository.findAll(pageable)).willReturn(Page.empty(pageable));
        Page<AnimatedCharacter> characterPage = animatedCharacterServiceImpl.findAll(pageableSearchDTO);
        assertThat(characterPage).isNotNull();
    }
}