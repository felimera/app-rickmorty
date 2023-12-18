package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;

public interface CalledTableRepositoryPort {
    CalledTablesDTO save(CalledTablesDTO calledTablesDTO);
    CalledTablesDTO saveWithError(CalledTablesDTO calledTablesDTO, SystemErrorDTO systemErrorDTO);
    CalledTablesDTO addCalledTables(String parameter, Object data, String typeRequest) ;
}
