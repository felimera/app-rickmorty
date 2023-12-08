package com.coderbyte.apprickmorty.controller.dto.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageableSearchDTO {
    private Integer order;
    private Integer initPage;
    private Integer sizePage;
}
