package com.coderbyte.apprickmorty.infrastructure.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String code;
    private String message;
}

