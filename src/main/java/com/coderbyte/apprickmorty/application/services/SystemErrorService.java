package com.coderbyte.apprickmorty.application.services;

import com.coderbyte.apprickmorty.domian.ports.in.system.CreateSystemErrorUseCase;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SystemErrorService implements CreateSystemErrorUseCase {
    private final CreateSystemErrorUseCase createSystemErrorUseCase;

    @Override
    public SystemErrorDTO postSystemError(SystemErrorDTO systemErrorDTO) {
        return createSystemErrorUseCase.postSystemError(systemErrorDTO);
    }

    @Override
    public SystemErrorDTO addSystemError(String code, String status, String message) {
        return createSystemErrorUseCase.addSystemError(code, status, message);
    }
}
