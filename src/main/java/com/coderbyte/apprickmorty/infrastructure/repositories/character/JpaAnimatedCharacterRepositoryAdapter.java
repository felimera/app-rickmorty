package com.coderbyte.apprickmorty.infrastructure.repositories.character;

import com.coderbyte.apprickmorty.domian.models.in.AnimatedCharacterEntity;
import com.coderbyte.apprickmorty.domian.models.out.CharacterSchema;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import com.coderbyte.apprickmorty.domian.ports.out.ExternalServicePort;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.TypeRequest;
import com.coderbyte.apprickmorty.infrastructure.entities.pages.AnimatedCharacterPageDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.infrastructure.exception.BusinessException;
import com.coderbyte.apprickmorty.infrastructure.exception.NotFoundException;
import com.coderbyte.apprickmorty.infrastructure.mapper.AnimatedCharacterMapper;
import com.coderbyte.apprickmorty.infrastructure.repositories.called.JpaCalledTablesRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.system.JpaSystemErrorRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.util.Constantes;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaAnimatedCharacterRepositoryAdapter implements AnimatedCharacterRepositoryPort {

    private final JpaAnimatedCharacterRepository jpaAnimatedCharacterRepository;
    private final ExternalServicePort externalServicePort;
    private final JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter;
    private final JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter;

    @Transactional
    @Override
    public AnimatedCharacterDTO save(AnimatedCharacterDTO animatedCharacterDTO) {
        List<CharacterSchema> characterSchemaList = externalServicePort.getCharacterSchemaInfor(animatedCharacterDTO.getName());
        if (characterSchemaList.isEmpty()) {
            AnimatedCharacterEntity animatedCharacterEntity = AnimatedCharacterMapper.INSTANCE.fromDomainModel(animatedCharacterDTO);
            AnimatedCharacterEntity savedCharacterEntity = jpaAnimatedCharacterRepository.save(animatedCharacterEntity);
            AnimatedCharacterDTO savedCharacterDTO = AnimatedCharacterMapper.INSTANCE.toDomainModel(savedCharacterEntity);
            jpaCalledTablesRepositoryAdapter.save(jpaCalledTablesRepositoryAdapter.addCalledTables(AnimatedCharacterDTO.class.toString(), savedCharacterDTO, TypeRequest.POST.name()));
            return savedCharacterDTO;
        } else {
            String code = "404-1";
            String message = "The record could not be saved.";

            SystemErrorDTO savedErrorDTO = jpaSystemErrorRepositoryAdapter.save(jpaSystemErrorRepositoryAdapter.addSystemError(code, HttpStatus.NOT_FOUND.name(), message));
            jpaCalledTablesRepositoryAdapter.saveWithError(jpaCalledTablesRepositoryAdapter.addCalledTables(AnimatedCharacterEntity.class.toString(), animatedCharacterDTO, TypeRequest.POST.name()), savedErrorDTO);
            throw new BusinessException(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
    }

    @Override
    public Optional<AnimatedCharacterDTO> findById(Long id) {
        return jpaAnimatedCharacterRepository.findById(id).map(AnimatedCharacterMapper.INSTANCE::toDomainModel);
    }

    @Override
    public List<AnimatedCharacterDTO> findAll(Integer order) {
        List<AnimatedCharacterEntity> characterEntityList = jpaAnimatedCharacterRepository.findAll(getWayToOrganizeData(order));
        if (characterEntityList.isEmpty()) {
            String code = "404-1";
            String message = "No records found.";
            SystemErrorDTO savedErrorDTO = jpaSystemErrorRepositoryAdapter.save(jpaSystemErrorRepositoryAdapter.addSystemError(code, HttpStatus.NOT_FOUND.name(), message));
            jpaCalledTablesRepositoryAdapter.saveWithError(jpaCalledTablesRepositoryAdapter.addCalledTables(Constantes.ORDER, order, TypeRequest.POST.name()), savedErrorDTO);
            throw new NotFoundException(message, code, HttpStatus.NOT_FOUND);
        }

        jpaCalledTablesRepositoryAdapter.save(jpaCalledTablesRepositoryAdapter.addCalledTables(Constantes.ORDER, order, TypeRequest.GET.name()));
        return characterEntityList.stream().map(AnimatedCharacterMapper.INSTANCE::toDomainModel).toList();
    }

    @Override
    public Optional<AnimatedCharacterDTO> update(Long id, AnimatedCharacterDTO animatedCharacterDTO) {
        if (jpaAnimatedCharacterRepository.existsById(id)) {
            AnimatedCharacterEntity animatedCharacterEntity = AnimatedCharacterMapper.INSTANCE.fromDomainModel(animatedCharacterDTO);
            AnimatedCharacterEntity updateCharacterEntity = jpaAnimatedCharacterRepository.save(animatedCharacterEntity);
            return Optional.of(AnimatedCharacterMapper.INSTANCE.toDomainModel(updateCharacterEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaAnimatedCharacterRepository.existsById(id)) {
            jpaAnimatedCharacterRepository.deleteById(id);
        }
        return !jpaAnimatedCharacterRepository.existsById(id);
    }

    @Override
    public AnimatedCharacterPageDTO getDtoPage(PageableSearchDTO dto) {
        Sort orders = this.getWayToOrganizeData(dto.getOrder());
        Pageable pageable = PageRequest.of(dto.getInitPage(), dto.getSizePage(), orders);

        jpaCalledTablesRepositoryAdapter.save(jpaCalledTablesRepositoryAdapter.addCalledTables(PageableSearchDTO.class.toString(), dto, TypeRequest.GET.name()));
        Page<AnimatedCharacterEntity> getCharacterEntities = jpaAnimatedCharacterRepository.findAll(pageable);
        return AnimatedCharacterMapper.INSTANCE.toPageDto(getCharacterEntities);
    }

    private Sort getWayToOrganizeData(int order) {
        String data;
        switch (order) {
            case 1:
                data = "name";
                break;
            case 2:
                data = "picture";
                break;
            case 3:
                data = "gender";
                break;
            case 4:
                data = "state";
                break;
            default:
                data = "id";
                break;
        }
        return Sort.by(Sort.Direction.ASC, data);
    }
}
