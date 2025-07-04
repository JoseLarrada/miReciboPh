package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.AsociadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
public interface AsociadosRepository extends JpaRepository<AsociadosEntity, BigDecimal> {
}
