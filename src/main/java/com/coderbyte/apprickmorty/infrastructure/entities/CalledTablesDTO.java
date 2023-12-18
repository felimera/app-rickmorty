package com.coderbyte.apprickmorty.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalledTablesDTO {
    private Integer id;
    private LocalDate registrationDate;
    private String typeRequest;
    private String loginInformation;
    private SystemErrorDTO systemErrorDTO;
}
