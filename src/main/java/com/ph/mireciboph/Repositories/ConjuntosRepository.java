package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.ConjuntosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ConjuntosRepository extends JpaRepository<ConjuntosEntity, BigDecimal> {
    Optional<ConjuntosEntity> findByNombreConjunto(String nombreConjunto);
}
