package com.coderbyte.apprickmorty.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnimatedCharacterPageDTO {
    private List<AnimatedCharacterDTO> content;
    private PageableDTO pageable;
    private Boolean last;
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
    private Integer number;
    private SortDTO sort;
    private Boolean first;
    private Integer numberOfElements;
    private Boolean empty;
}
