package com.coderbyte.apprickmorty.application.usecases.system;

import com.coderbyte.apprickmorty.domian.ports.in.system.CreateSystemErrorUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.SystemErrorRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateSystemErrorUserCaseImpl implements CreateSystemErrorUseCase {

    private final SystemErrorRepositoryPort systemErrorRepositoryPort;

    @Override
    public SystemErrorDTO postSystemError(SystemErrorDTO systemErrorDTO) {
        return systemErrorRepositoryPort.save(systemErrorDTO);
    }

    @Override
    public SystemErrorDTO addSystemError(String code, String status, String message) {
        return systemErrorRepositoryPort.addSystemError(code, status, message);
    }
}
