package com.coderbyte.apprickmorty.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemErrorDTO {
    private Integer id;
    private String code;
    private String status;
    private String message;
}
