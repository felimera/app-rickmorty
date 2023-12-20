package com.coderbyte.apprickmorty.infrastructure.repositories.system;

import com.coderbyte.apprickmorty.domian.models.in.SystemErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSystemErrorRepository extends JpaRepository<SystemErrorEntity, Long> {
}
