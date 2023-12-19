package com.coderbyte.apprickmorty.domian.ports.in.precondition;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;

public interface RetrieveAnimatedPreconditionUseCase {
    void checkOrderBy(String order);

    void checkNullBodyField(AnimatedCharacterDTO dto);

    void checkInitPageBy(String initPage);

    void checkSizePageBy(String sizePage);
}
