package com.coderbyte.apprickmorty.infrastructure.entities.pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private SortDTO sort;
    private Integer offset;
    private Boolean paged;
    private Boolean unpaged;
}
