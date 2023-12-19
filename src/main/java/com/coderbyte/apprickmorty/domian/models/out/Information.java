package com.coderbyte.apprickmorty.domian.models.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
