package com.coderbyte.apprickmorty.domian.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalledTables {
    private Integer id;
    private LocalDate registrationDate;
    private String typeRequest;
    private String loginInformation;
    private SystemError systemError;
}
