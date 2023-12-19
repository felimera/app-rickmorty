package com.coderbyte.apprickmorty.application.usecases.precondition;

import com.coderbyte.apprickmorty.domian.ports.in.precondition.RetrieveAnimatedPreconditionUseCase;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedPreconditionRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveAnimatedPreconditionUseCaseImpl implements RetrieveAnimatedPreconditionUseCase {

    private final AnimatedPreconditionRepositoryPort animatedPreconditionRepositoryPort;

    @Override
    public void checkOrderBy(String order) {
        animatedPreconditionRepositoryPort.checkOrderBy(order);
    }

    @Override
    public void checkNullBodyField(AnimatedCharacterDTO dto) {
        animatedPreconditionRepositoryPort.checkNullBodyField(dto);
    }

    @Override
    public void checkInitPageBy(String initPage) {
        animatedPreconditionRepositoryPort.checkInitPageBy(initPage);
    }

    @Override
    public void checkSizePageBy(String sizePage) {
        animatedPreconditionRepositoryPort.checkSizePageBy(sizePage);
    }
}
