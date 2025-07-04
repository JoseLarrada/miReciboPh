package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.CiudadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
public interface CiudadesRepository extends JpaRepository<CiudadesEntity, BigDecimal> {
}
