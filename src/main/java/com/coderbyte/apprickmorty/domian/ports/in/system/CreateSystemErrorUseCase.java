package com.coderbyte.apprickmorty.domian.ports.in.system;

import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;

public interface CreateSystemErrorUseCase {
    SystemErrorDTO postSystemError(SystemErrorDTO systemErrorDTO);
    SystemErrorDTO addSystemError(String code, String status, String message);
}
