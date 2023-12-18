package com.coderbyte.apprickmorty.application.services;

import com.coderbyte.apprickmorty.domian.ports.in.called.CreateCalledTablesUseCase;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalledTablesService implements CreateCalledTablesUseCase {
    private final CreateCalledTablesUseCase createCalledTablesUseCase;

    @Override
    public void postCalledTables(CalledTablesDTO calledTablesDTO) {
        createCalledTablesUseCase.postCalledTables(calledTablesDTO);
    }

    @Override
    public void postCalledTablesWithError(CalledTablesDTO calledTablesDTO, SystemErrorDTO systemErrorDTO) {
        createCalledTablesUseCase.postCalledTablesWithError(calledTablesDTO, systemErrorDTO);
    }

    @Override
    public CalledTablesDTO addCalledTables(String parameter, Object data, String typeRequest) {
        return createCalledTablesUseCase.addCalledTables(parameter, data, typeRequest);
    }
}
