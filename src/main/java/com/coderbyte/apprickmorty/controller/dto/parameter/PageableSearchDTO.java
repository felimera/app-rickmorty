package com.coderbyte.apprickmorty.controller.dto.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableSearchDTO {
    private Integer order;
    private Integer initPage;
    private Integer sizePage;
}
