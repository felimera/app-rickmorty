package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;

public interface SystemErrorRepositoryPort {
    SystemErrorDTO save(SystemErrorDTO systemErrorDTO);
    SystemErrorDTO addSystemError(String code, String status, String message);
}
