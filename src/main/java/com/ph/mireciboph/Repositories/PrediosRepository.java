package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.PrediosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PrediosRepository extends JpaRepository<PrediosEntity, BigDecimal> {
    Optional<PrediosEntity> findByReferenciaPago(String referenciaPago);
}
