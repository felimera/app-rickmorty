package com.coderbyte.apprickmorty.infrastructure.repositories;

import com.coderbyte.apprickmorty.domian.models.in.CalledTablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCalledTablesRespository extends JpaRepository<CalledTablesEntity, Long> {
}
