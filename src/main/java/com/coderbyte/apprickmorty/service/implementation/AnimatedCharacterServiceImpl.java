package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.controller.dto.parameter.PageableSearchDTO;
import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.exception.NotFoundException;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.repository.AnimatedCharacterRepository;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.utils.CadenaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimatedCharacterServiceImpl implements AnimatedCharacterService {

    private AnimatedCharacterRepository animatedCharacterRepository;
    private CalledTablesService calledTablesService;

    private static final String ORDER = "order";

    @Autowired
    public AnimatedCharacterServiceImpl(AnimatedCharacterRepository animatedCharacterRepository, CalledTablesService calledTablesService) {
        this.animatedCharacterRepository = animatedCharacterRepository;
        this.calledTablesService = calledTablesService;
    }

    @Override
    public List<AnimatedCharacter> getAll(int order) {
        try {
            List<AnimatedCharacter> animatedCharacterList = animatedCharacterRepository.findAll(this.getWayToOrganizeData(order));
            if (animatedCharacterList.isEmpty()) {
                String code = "404-1";
                String status = HttpStatus.NOT_FOUND.name();
                String message = "No records found.";

                calledTablesService.postCalledTablesWithError(addCalledTables(ORDER, order, "GET"), addSystemError(code, status, message));

                throw new NotFoundException(message, code, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            calledTablesService.postCalledTables(addCalledTables(ORDER, order, "GET"));

            return animatedCharacterList;
        } catch (Exception e) {
            String code = "501-1";
            String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
            String message = "Error in the query." + e.getMessage();

            calledTablesService.postCalledTablesWithError(addCalledTables(ORDER, order, "GET"), addSystemError(code, status, message));

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

            calledTablesService.postCalledTablesWithError(addCalledTables("animatedCharacter", animatedCharacter, "POST"), addSystemError(code, status, message));

            throw new BusinessException(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
        AnimatedCharacter entity = animatedCharacterRepository.save(animatedCharacter);
        calledTablesService.postCalledTables(addCalledTables("animatedCharacter", entity, "POST"));
        return entity;
    }

    @Override
    public Page<AnimatedCharacter> findAll(PageableSearchDTO dto) {
        Sort orders = this.getWayToOrganizeData(dto.getOrder());
        Pageable pageable = PageRequest.of(dto.getInitPage(), dto.getSizePage(), orders);

        return animatedCharacterRepository.findAll(pageable);
    }

    private CalledTables addCalledTables(String parameter, Object data, String typeRequest) {
        CalledTables tables = new CalledTables();
        tables.setRegistrationDate(LocalDate.now());
        tables.setTypeRequest(typeRequest);
        tables.setLoginInformation(CadenaUtil.convertBodyToJson(parameter, data));
        return tables;
    }

    private SystemError addSystemError(String code, String status, String message) {
        SystemError systemError = new SystemError();
        systemError.setCode(code);
        systemError.setStatus(status);
        systemError.setMessage(message);
        return systemError;
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
