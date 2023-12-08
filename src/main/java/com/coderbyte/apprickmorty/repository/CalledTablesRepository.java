package com.coderbyte.apprickmorty.repository;

import com.coderbyte.apprickmorty.model.CalledTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledTablesRepository extends JpaRepository< CalledTables,Integer> {
}
