package com.coderbyte.apprickmorty.builder.models.in;

import com.coderbyte.apprickmorty.domian.models.in.SystemErrorEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SystemErrorEntityBuilder {
    private Integer id;
    private String code;
    private String status;
    private String message;

    private SystemErrorEntityBuilder toSystemErrorEntityBuilder() {
        return SystemErrorEntityBuilder.builder()
                .id(1)
                .code("301-1")
                .status(HttpStatus.BAD_REQUEST.name())
                .message("La informacion no se pude gestionar correctamente.")
                .build();
    }

    public SystemErrorEntity toSystemErrorEntity() {
        SystemErrorEntityBuilder builder = toSystemErrorEntityBuilder();
        return new SystemErrorEntity(builder.id, builder.code, builder.status, builder.message);
    }
}
