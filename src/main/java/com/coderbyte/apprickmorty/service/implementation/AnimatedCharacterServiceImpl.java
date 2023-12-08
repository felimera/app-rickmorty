package com.coderbyte.apprickmorty.service.implementation;

import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.model.AnimatedCharacter;
import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.repository.AnimatedCharacterRepository;
import com.coderbyte.apprickmorty.service.AnimatedCharacterService;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.utils.CadenaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnimatedCharacterServiceImpl implements AnimatedCharacterService {

    private AnimatedCharacterRepository animatedCharacterRepository;
    private CalledTablesService calledTablesService;

    @Autowired
    public AnimatedCharacterServiceImpl(AnimatedCharacterRepository animatedCharacterRepository, CalledTablesService calledTablesService) {
        this.animatedCharacterRepository = animatedCharacterRepository;
        this.calledTablesService = calledTablesService;
    }

    @Override
    public List<AnimatedCharacter> getAll() {
        return animatedCharacterRepository.findAll();
    }

    @Override
    public AnimatedCharacter postAnimatedCharacter(AnimatedCharacter animatedCharacter) {

        Optional<AnimatedCharacter> animatedCharacterOptional = animatedCharacterRepository.findByName(animatedCharacter.getName().toUpperCase());
        if (animatedCharacterOptional.isPresent()) {
            String code = "404-1";
            String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
            String message = "The record could not be saved.";

            calledTablesService.postCalledTablesWithError(addCalledTables(animatedCharacter), addSystemError(code, status, message));

            throw new BusinessException(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
        AnimatedCharacter entity = animatedCharacterRepository.save(animatedCharacter);
        calledTablesService.postCalledTables(addCalledTables(entity));
        return entity;
    }

    private CalledTables addCalledTables(AnimatedCharacter entity) {
        CalledTables tables = new CalledTables();
        tables.setRegistrationDate(LocalDate.now());
        tables.setTypeRequest("POST");
        tables.setLoginInformation(CadenaUtil.convertBodyToJson("animatedCharacters", entity));
        return tables;
    }

    private SystemError addSystemError(String code, String status, String message) {
        SystemError systemError = new SystemError();
        systemError.setCode(code);
        systemError.setStatus(status);
        systemError.setMessage(message);
        return systemError;
    }
}
