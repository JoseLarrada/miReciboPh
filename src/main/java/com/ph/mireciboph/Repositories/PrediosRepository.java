package com.ph.mireciboph.Repositories;

import com.ph.mireciboph.Entity.DTO.ReciboInfoDTO;
import com.ph.mireciboph.Entity.PrediosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PrediosRepository extends JpaRepository<PrediosEntity, BigDecimal> {
    Optional<PrediosEntity> findByReferenciaPago(String referenciaPago);
    @Query("""
    SELECT new com.ph.mireciboph.Entity.DTO.ReciboInfoDTO(
        p.referenciaPago, p.nombrePredio, r.fecha,
        r.segundoCampo, r.tercerCampo, r.cuartoCampo,
        r.quintoCampo, r.sextoCampo, r.septimoCampo,
        r.octavoCampo, r.novenoCampo, r.decimoCampo,
        per.nombrePersona, c.primerConcepto
    )
    FROM PrediosEntity p
    JOIN RecibosEntity r ON r.codigoPredio = p.codigoPredio
    JOIN AsociadosEntity a ON a.codigoPredio = p.codigoPredio
    JOIN PersonasEntity per ON per.codigoPersona = a.codigoPersona
    JOIN ConjuntosEntity c ON c.codigoConjunto = p.codigoConjunto
    WHERE p.referenciaPago = :refPago
    """)
    Optional<ReciboInfoDTO> buscarPorReferencia(@Param("refPago") String refPago);
}
