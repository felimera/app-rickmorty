package com.coderbyte.apprickmorty.infrastructure.config;

import com.coderbyte.apprickmorty.application.services.AnimatedCharacterService;
import com.coderbyte.apprickmorty.application.usecases.character.CreateAnimatedCharacterUserCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.DeleteAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.RetrieveAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.application.usecases.character.UpdateAnimatedCharacterUseCaseImpl;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import com.coderbyte.apprickmorty.domian.ports.out.ExternalServicePort;
import com.coderbyte.apprickmorty.infrastructure.adapters.ExternalServiceAdapter;
import com.coderbyte.apprickmorty.infrastructure.repositories.JpaAnimatedCharacterRepositoryAdapter;
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
}