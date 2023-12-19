package com.coderbyte.apprickmorty.domian.ports.out;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;

public interface AnimatedPreconditionRepositoryPort {
    void checkOrderBy(String order);

    void checkNullBodyField(AnimatedCharacterDTO dto);

    void checkInitPageBy(String initPage);

    void checkSizePageBy(String sizePage);
}
