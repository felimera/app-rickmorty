package com.coderbyte.apprickmorty.service.precondition;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import org.springframework.stereotype.Service;

@Service
public interface AnimatedPreconditionService {

    void checkOrderBy(String order);

    void checkNullBodyField(AnimatedCharacterDTO dto);

    void checkInitPageBy(String initPage);

    void checkSizePageBy(String sizePage);
}
