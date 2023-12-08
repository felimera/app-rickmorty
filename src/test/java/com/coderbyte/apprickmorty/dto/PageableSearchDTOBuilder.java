package com.coderbyte.apprickmorty.dto;

import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageableSearchDTOBuilder {
    private Integer order;
    private Integer initPage;
    private Integer sizePage;

    private PageableSearchDTOBuilder toPageableSearchDTOBuilder() {
        return PageableSearchDTOBuilder.builder()
                .order(1)
                .initPage(2)
                .sizePage(2)
                .build();
    }

    public PageableSearchDTO toPageableSearchDTO() {
        PageableSearchDTOBuilder builder = toPageableSearchDTOBuilder();
        return new PageableSearchDTO(builder.order, builder.initPage, builder.sizePage);
    }
}
