package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.SystemError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemErrorRepository extends JpaRepository<SystemError, Integer> {
}
