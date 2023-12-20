package com.coderbyte.apprickmorty.infrastructure.repositories.called;

import com.coderbyte.apprickmorty.domian.models.in.CalledTablesEntity;
import com.coderbyte.apprickmorty.domian.models.in.SystemErrorEntity;
import com.coderbyte.apprickmorty.domian.ports.out.CalledTableRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.mapper.CalledTableMapper;
import com.coderbyte.apprickmorty.infrastructure.mapper.SystemErrorMapper;
import com.coderbyte.apprickmorty.infrastructure.util.CadenaUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class JpaCalledTablesRepositoryAdapter implements CalledTableRepositoryPort {

    private final JpaCalledTablesRepository jpaCalledTablesRespository;

    @Override
    public CalledTablesDTO save(CalledTablesDTO calledTablesDTO) {
        CalledTablesEntity calledTablesEntity = CalledTableMapper.INSTANCE.fromDomainModel(calledTablesDTO);
        CalledTablesEntity savedCalledTables = jpaCalledTablesRespository.save(calledTablesEntity);

        return CalledTableMapper.INSTANCE.toDomainModel(savedCalledTables);
    }

    @Override
    public CalledTablesDTO saveWithError(CalledTablesDTO calledTablesDTO, SystemErrorDTO systemErrorDTO) {
        CalledTablesEntity calledTablesEntity = CalledTableMapper.INSTANCE.fromDomainModel(calledTablesDTO);
        SystemErrorEntity systemErrorEntity = SystemErrorMapper.INSTANCE.fromDomainModel(systemErrorDTO);
        calledTablesEntity.setSystemErrorEntity(systemErrorEntity);
        CalledTablesEntity savedCalledTables = jpaCalledTablesRespository.save(calledTablesEntity);

        return CalledTableMapper.INSTANCE.toDomainModel(savedCalledTables);
    }

    @Override
    public CalledTablesDTO addCalledTables(String parameter, Object data, String typeRequest) {
        CalledTablesDTO tables = new CalledTablesDTO();
        tables.setRegistrationDate(LocalDate.now());
        tables.setTypeRequest(typeRequest);
        tables.setLoginInformation(CadenaUtil.convertBodyToJson(parameter, data));
        return tables;
    }
}
