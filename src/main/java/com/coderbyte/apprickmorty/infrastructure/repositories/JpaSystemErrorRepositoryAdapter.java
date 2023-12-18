package com.coderbyte.apprickmorty.infrastructure.repositories;

import com.coderbyte.apprickmorty.domian.models.SystemErrorEntity;
import com.coderbyte.apprickmorty.domian.ports.out.SystemErrorRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.mapper.SystemErrorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JpaSystemErrorRepositoryAdapter implements SystemErrorRepositoryPort {

    private final JpaSystemErrorRepository jpaSystemErrorRepository;

    @Override
    public SystemErrorDTO save(SystemErrorDTO systemErrorDTO) {
        SystemErrorEntity systemErrorEntity = SystemErrorMapper.INSTANCE.fromDomainModel(systemErrorDTO);
        SystemErrorEntity savedSystemError = jpaSystemErrorRepository.save(systemErrorEntity);

        return SystemErrorMapper.INSTANCE.toDomainModel(savedSystemError);
    }

    @Override
    public SystemErrorDTO addSystemError(String code, String status, String message) {
        SystemErrorDTO systemError = new SystemErrorDTO();
        systemError.setCode(code);
        systemError.setStatus(status);
        systemError.setMessage(message);
        return systemError;
    }
}
