package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.RecibosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Repository
public interface RecibosRepository extends JpaRepository<RecibosEntity, BigDecimal> {
    Optional<RecibosEntity> findByCodigoPredioAndFecha(BigDecimal codigoPredio, Date fecha);
}
