package com.coderbyte.apprickmorty.builder.entities;

import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.TypeRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CalledTablesDTOBuilder {
    private Integer id;
    private LocalDate registrationDate;
    private String typeRequest;
    private String loginInformation;
    private SystemErrorDTO systemErrorDTO;

    private CalledTablesDTOBuilder toCalledTablesDTOBuilder() {
        return CalledTablesDTOBuilder.builder()
                .id(1)
                .registrationDate(LocalDate.now())
                .typeRequest(TypeRequest.POST.name())
                .loginInformation("")
                .systemErrorDTO(null)
                .build();
    }

    public CalledTablesDTO toCalledTablesDTO() {
        CalledTablesDTOBuilder builder = toCalledTablesDTOBuilder();
        return new CalledTablesDTO(builder.id, builder.registrationDate, builder.typeRequest, builder.loginInformation, builder.systemErrorDTO);
    }
}
