package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.repository.CalledTablesRepository;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalledTablesServiceImpl implements CalledTablesService {

    private CalledTablesRepository calledTablesRepository;
    private SystemErrorService systemErrorService;

    @Autowired
    public CalledTablesServiceImpl(CalledTablesRepository calledTablesRepository, SystemErrorService systemErrorService) {
        this.calledTablesRepository = calledTablesRepository;
        this.systemErrorService = systemErrorService;
    }

    @Override
    public CalledTables postCalledTables(CalledTables calledTables) {
        return calledTablesRepository.save(calledTables);
    }

    @Override
    public CalledTables postCalledTablesWithError(CalledTables calledTables, SystemError systemError) {
        SystemError error = systemErrorService.postSystemError(systemError);
        calledTables.setSystemError(error);
        return calledTablesRepository.save(calledTables);
    }
}
