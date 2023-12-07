package com.coderbyte.apprickmorty.service;

import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import org.springframework.stereotype.Service;

@Service
public interface CalledTablesService {
    CalledTables postCalledTables(CalledTables calledTables);

    CalledTables postCalledTablesWithError(CalledTables calledTables, SystemError systemError);
}
