package com.coderbyte.apprickmorty.entity;

import com.coderbyte.apprickmorty.model.SystemError;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SystemErrorBuilder {
    private Integer id;
    private String code;
    private String status;
    private String message;

    private SystemErrorBuilder toSystemErrorBuilder() {
        return SystemErrorBuilder.builder()
                .id(1)
                .code("301-1")
                .status(HttpStatus.BAD_REQUEST.name())
                .message("La informacion no se pude gestionar correctamente.")
                .build();
    }

    public SystemError toSystemError() {
        SystemErrorBuilder builder = toSystemErrorBuilder();
        return new SystemError(builder.id, builder.code, builder.status, builder.message);
    }
}
