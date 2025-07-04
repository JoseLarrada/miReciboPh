package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.PersonasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PersonasRepository extends JpaRepository<PersonasEntity, BigDecimal> {
}
