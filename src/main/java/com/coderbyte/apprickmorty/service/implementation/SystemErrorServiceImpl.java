package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.repository.SystemErrorRepository;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemErrorServiceImpl implements SystemErrorService {

    private SystemErrorRepository systemErrorRepository;

    @Autowired
    public SystemErrorServiceImpl(SystemErrorRepository systemErrorRepository) {
        this.systemErrorRepository = systemErrorRepository;
    }

    @Override
    public SystemError postSystemError(SystemError systemError) {
        return systemErrorRepository.save(systemError);
    }

    @Override
    public SystemError addSystemError(String code, String status, String message) {
        SystemError systemError = new SystemError();
        systemError.setCode(code);
        systemError.setStatus(status);
        systemError.setMessage(message);
        return systemError;
    }
}
