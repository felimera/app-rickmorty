package com.coderbyte.apprickmorty.domian.ports.in.called;

import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;

public interface CreateCalledTablesUseCase {
    void postCalledTables(CalledTablesDTO calledTablesDTO);

    void postCalledTablesWithError(CalledTablesDTO calledTablesDTO, SystemErrorDTO systemErrorDTO);

    CalledTablesDTO addCalledTables(String parameter, Object data, String typeRequest);
}
