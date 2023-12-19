package com.coderbyte.apprickmorty.infrastructure.config;

import com.coderbyte.apprickmorty.application.services.AnimatedCharacterService;
import com.coderbyte.apprickmorty.application.services.AnimatedPreconditionService;
import com.coderbyte.apprickmorty.application.services.CalledTablesService;
import com.coderbyte.apprickmorty.application.services.SystemErrorService;
import com.coderbyte.apprickmorty.application.usecases.called.CreateCalledTableUserCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.CreateAnimatedCharacterUserCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.DeleteAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.RetrieveAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.UpdateAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.precondition.RetrieveAnimatedPreconditionUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.system.CreateSystemErrorUserCaseImpl;
import com.coderbyte.apprickmorty.domian.ports.out.*;
import com.coderbyte.apprickmorty.infrastructure.adapters.ExternalServiceAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.JpaAnimatedCharacterRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.JpaAnimatedPreconditionRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.JpaCalledTablesRepositoryAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.JpaSystemErrorRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public AnimatedCharacterService animatedCharacterService(AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort) {
        return new AnimatedCharacterService(
                new CreateAnimatedCharacterUserCaseImpl(animatedCharacterRepositoryPort),
                new RetrieveAnimatedCharacterUseCaseImpl(animatedCharacterRepositoryPort),
                new UpdateAnimatedCharacterUseCaseImpl(animatedCharacterRepositoryPort),
                new DeleteAnimatedCharacterUseCaseImpl(animatedCharacterRepositoryPort)
        );
    }

    @Bean
    public AnimatedCharacterRepositoryPort animatedCharacterRepositoryPort(JpaAnimatedCharacterRepositoryAdapter jpaAnimatedCharacterRepositoryAdapter) {
        return jpaAnimatedCharacterRepositoryAdapter;
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

    @Bean
    public CalledTablesService calledTableService(CalledTableRepositoryPort calledTableRepositoryPort) {
        return new CalledTablesService(
                new CreateCalledTableUserCaseImpl(calledTableRepositoryPort)
        );
    }

    @Bean
    public CalledTableRepositoryPort calledTableRepositoryPort(JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter) {
        return jpaCalledTablesRepositoryAdapter;
    }

    @Bean
    public SystemErrorService systemErrorService(SystemErrorRepositoryPort systemErrorRepositoryPort) {
        return new SystemErrorService(
                new CreateSystemErrorUserCaseImpl(systemErrorRepositoryPort)
        );
    }

    @Bean
    public SystemErrorRepositoryPort systemErrorRepositoryPort(JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter) {
        return jpaSystemErrorRepositoryAdapter;
    }

    @Bean
    public AnimatedPreconditionService animatedPreconditionService(AnimatedPreconditionRepositoryPort animatedPreconditionRepositoryPort) {
        return new AnimatedPreconditionService(
                new RetrieveAnimatedPreconditionUseCaseImpl(animatedPreconditionRepositoryPort)
        );
    }

    @Bean
    public AnimatedPreconditionRepositoryPort animatedPreconditionRepositoryPort(JpaAnimatedPreconditionRepositoryAdapter jpaAnimatedPreconditionRepositoryAdapter) {
        return jpaAnimatedPreconditionRepositoryAdapter;
    }
}