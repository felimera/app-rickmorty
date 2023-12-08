package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.exception.NotFoundException;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.model.TypeRequest;
import com.coderbyte.apprickmorty.repository.AnimatedCharacterRepository;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimatedCharacterServiceImpl implements AnimatedCharacterService {

    private AnimatedCharacterRepository animatedCharacterRepository;
    private CalledTablesService calledTablesService;
    private SystemErrorService systemErrorService;

    private static final String ORDER = "order";

    @Autowired
    public AnimatedCharacterServiceImpl(AnimatedCharacterRepository animatedCharacterRepository, CalledTablesService calledTablesService, SystemErrorService systemErrorService) {
        this.animatedCharacterRepository = animatedCharacterRepository;
        this.calledTablesService = calledTablesService;
        this.systemErrorService = systemErrorService;
    }

    @Override
    public List<AnimatedCharacter> getAll(int order) {
        try {
            List<AnimatedCharacter> animatedCharacterList = animatedCharacterRepository.findAll(this.getWayToOrganizeData(order));
            if (animatedCharacterList.isEmpty()) {
                String code = "404-1";
                String status = HttpStatus.NOT_FOUND.name();
                String message = "No records found.";

                calledTablesService.postCalledTablesWithError(calledTablesService.addCalledTables(ORDER, order, TypeRequest.GET.name()), systemErrorService.addSystemError(code, status, message));

                throw new NotFoundException(message, code, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            calledTablesService.postCalledTables(calledTablesService.addCalledTables(ORDER, order, TypeRequest.GET.name()));

            return animatedCharacterList;
        } catch (Exception e) {
            String code = "501-1";
            String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
            String message = "Error in the query." + e.getMessage();

            calledTablesService.postCalledTablesWithError(calledTablesService.addCalledTables(ORDER, order, TypeRequest.GET.name()), systemErrorService.addSystemError(code, status, message));

            throw new BusinessException(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
    }

    @Override
    public AnimatedCharacter postAnimatedCharacter(AnimatedCharacter animatedCharacter) {

        Boolean isExistAnimeted = animatedCharacterRepository.isExistByName(animatedCharacter.getName().toUpperCase());
        if (Boolean.TRUE.equals(isExistAnimeted)) {
            String code = "404-1";
            String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
            String message = "The record could not be saved.";

            calledTablesService.postCalledTablesWithError(calledTablesService.addCalledTables(AnimatedCharacter.class.toString(), animatedCharacter, TypeRequest.POST.name()), systemErrorService.addSystemError(code, status, message));

            throw new BusinessException(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
        AnimatedCharacter entity = animatedCharacterRepository.save(animatedCharacter);
        calledTablesService.postCalledTables(calledTablesService.addCalledTables(AnimatedCharacter.class.toString(), entity, TypeRequest.POST.name()));
        return entity;
    }

    @Override
    public Page<AnimatedCharacter> findAll(PageableSearchDTO dto) {
        Sort orders = this.getWayToOrganizeData(dto.getOrder());
        Pageable pageable = PageRequest.of(dto.getInitPage(), dto.getSizePage(), orders);

        calledTablesService.postCalledTables(calledTablesService.addCalledTables(PageableSearchDTO.class.toString(), dto, TypeRequest.GET.name()));
        return animatedCharacterRepository.findAll(pageable);
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
