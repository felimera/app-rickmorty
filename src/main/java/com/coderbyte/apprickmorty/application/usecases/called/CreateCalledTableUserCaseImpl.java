package com.coderbyte.apprickmorty.application.usecases.called;

import com.coderbyte.apprickmorty.domian.ports.in.called.CreateCalledTablesUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.CalledTableRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCalledTableUserCaseImpl implements CreateCalledTablesUseCase {

    private final CalledTableRepositoryPort calledTableRepositoryPort;

    @Override
    public void postCalledTables(CalledTablesDTO calledTablesDTO) {
        calledTableRepositoryPort.save(calledTablesDTO);
    }

    @Override
    public void postCalledTablesWithError(CalledTablesDTO calledTablesDTO, SystemErrorDTO systemErrorDTO) {
        calledTableRepositoryPort.saveWithError(calledTablesDTO,systemErrorDTO);
    }

    @Override
    public CalledTablesDTO addCalledTables(String parameter, Object data, String typeRequest) {
        return calledTableRepositoryPort.addCalledTables(parameter, data, typeRequest);
    }
}
