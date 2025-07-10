package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.AsociadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AsociadosRepository extends JpaRepository<AsociadosEntity, BigDecimal> {
    boolean existsByCodigoPredio(BigDecimal bigDecimal);
    Optional<AsociadosEntity> findByCodigoPredio(BigDecimal codPredio);

}
