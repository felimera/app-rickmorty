package com.coderbyte.apprickmorty.application.services;

import com.coderbyte.apprickmorty.domian.ports.in.precondition.RetrieveAnimatedPreconditionUseCase;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnimatedPreconditionService implements RetrieveAnimatedPreconditionUseCase {

    private final RetrieveAnimatedPreconditionUseCase retrieveAnimatedPreconditionUseCase;

    @Override
    public void checkOrderBy(String order) {
        retrieveAnimatedPreconditionUseCase.checkOrderBy(order);
    }

    @Override
    public void checkNullBodyField(AnimatedCharacterDTO dto) {
        retrieveAnimatedPreconditionUseCase.checkNullBodyField(dto);
    }

    @Override
    public void checkInitPageBy(String initPage) {
        retrieveAnimatedPreconditionUseCase.checkInitPageBy(initPage);
    }

    @Override
    public void checkSizePageBy(String sizePage) {
        retrieveAnimatedPreconditionUseCase.checkSizePageBy(sizePage);
    }
}
