package com.coderbyte.apprickmorty.entity;

import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.model.TypeRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CalledTablesBuilder {
    private Integer id;
    private LocalDate registrationDate;
    private String typeRequest;
    private String loginInformation;
    private SystemError systemError;

    private CalledTablesBuilder toCalledTablesBuilder() {
        return CalledTablesBuilder.builder()
                .id(1)
                .registrationDate(LocalDate.now())
                .typeRequest(TypeRequest.POST.name())
                .loginInformation("{name:RickeMorty}")
                .systemError(null)
                .build();
    }

    public CalledTables toCalledTables() {
        CalledTablesBuilder builder = toCalledTablesBuilder();
        return new CalledTables(builder.id, builder.registrationDate, builder.typeRequest, builder.loginInformation, builder.systemError);
    }
}
