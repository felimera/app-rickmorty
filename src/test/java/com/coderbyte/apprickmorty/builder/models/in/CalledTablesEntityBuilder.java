package com.coderbyte.apprickmorty.builder.models.in;

import com.coderbyte.apprickmorty.domian.models.in.CalledTablesEntity;
import com.coderbyte.apprickmorty.domian.models.in.SystemErrorEntity;
import com.coderbyte.apprickmorty.infrastructure.entities.TypeRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CalledTablesEntityBuilder {
    private Integer id;
    private LocalDate registrationDate;
    private String typeRequest;
    private String loginInformation;
    private SystemErrorEntity systemErrorEntity;

    private CalledTablesEntityBuilder toCalledTablesEntityBuilder() {
        return CalledTablesEntityBuilder.builder()
                .id(1)
                .registrationDate(LocalDate.now())
                .typeRequest(TypeRequest.POST.name())
                .loginInformation("")
                .systemErrorEntity(null)
                .build();
    }

    public CalledTablesEntity toCalledTablesEntity() {
        CalledTablesEntityBuilder builder = toCalledTablesEntityBuilder();
        return new CalledTablesEntity(builder.id, builder.registrationDate, builder.typeRequest, builder.loginInformation, builder.systemErrorEntity);
    }
}
