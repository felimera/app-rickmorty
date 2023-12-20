package com.coderbyte.apprickmorty.builder.entities;

import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SystemErrorDTOBuilder {
    private Integer id;
    private String code;
    private String status;
    private String message;

    private SystemErrorDTOBuilder toSystemErrorDTOBuilder() {
        return SystemErrorDTOBuilder.builder()
                .id(1)
                .code("500-01")
                .status(HttpStatus.BAD_REQUEST.name())
                .message("La informacion no se pude gestionar correctamente.")
                .build();
    }

    public SystemErrorDTO toSystemErrorDTO() {
        SystemErrorDTOBuilder builder = toSystemErrorDTOBuilder();
        return new SystemErrorDTO(builder.id, builder.code, builder.status, builder.message);
    }
}
