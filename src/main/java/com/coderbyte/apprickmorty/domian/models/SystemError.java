package com.coderbyte.apprickmorty.domian.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemError {
    private Integer id;
    private String code;
    private String status;
    private String message;
}
