package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.RecibosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RecibosRepository extends JpaRepository<RecibosEntity, BigDecimal> {
}
