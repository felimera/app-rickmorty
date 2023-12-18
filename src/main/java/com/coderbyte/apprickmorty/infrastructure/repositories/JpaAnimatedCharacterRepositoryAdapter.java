package com.coderbyte.apprickmorty.infrastructure.repositories;

import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.domian.ports.out.AnimatedCharacterRepositoryPort;
import com.coderbyte.apprickmorty.domian.models.AnimatedCharacterEntity;
import com.coderbyte.apprickmorty.infrastructure.mapper.AnimatedCharacterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaAnimatedCharacterRepositoryAdapter implements AnimatedCharacterRepositoryPort {

    private final JpaAnimatedCharacterRepository jpaAnimatedCharacterRepository;

    public AnimatedCharacterDTO save(AnimatedCharacterDTO animatedCharacterDTO) {
        AnimatedCharacterEntity animatedCharacterEntity = AnimatedCharacterMapper.INSTANCE.fromDomainModel(animatedCharacterDTO);
        AnimatedCharacterEntity savedCharacterEntity = jpaAnimatedCharacterRepository.save(animatedCharacterEntity);
        return AnimatedCharacterMapper.INSTANCE.toDomainModel(savedCharacterEntity);
    }

    @Override
    public Optional<AnimatedCharacterDTO> findById(Long id) {
        return jpaAnimatedCharacterRepository.findById(id).map(AnimatedCharacterMapper.INSTANCE::toDomainModel);
    }

    @Override
    public List<AnimatedCharacterDTO> findAll(Integer order) {
        return jpaAnimatedCharacterRepository.findAll().stream().map(AnimatedCharacterMapper.INSTANCE::toDomainModel).toList();
    }

    @Override
    public Optional<AnimatedCharacterDTO> update(Long id, AnimatedCharacterDTO animatedCharacterDTO) {
        if (jpaAnimatedCharacterRepository.existsById(id)) {
            AnimatedCharacterEntity animatedCharacterEntity = AnimatedCharacterMapper.INSTANCE.fromDomainModel(animatedCharacterDTO);
            AnimatedCharacterEntity updateCharacterEntity = jpaAnimatedCharacterRepository.save(animatedCharacterEntity);
            return Optional.of(AnimatedCharacterMapper.INSTANCE.toDomainModel(updateCharacterEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaAnimatedCharacterRepository.existsById(id)) {
            jpaAnimatedCharacterRepository.deleteById(id);
        }
        return !jpaAnimatedCharacterRepository.existsById(id);
    }
}
