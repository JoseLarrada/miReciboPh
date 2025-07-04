package com.ph.mireciboph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "predios")
public class PrediosEntity {
    @Id
    @Column(name = "codPredio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoPredio;
    @Column(name = "codConjunto")
    private BigDecimal codigoConjunto;
    @Column(name = "refPago")
    private String referenciaPago;
    @Column(name = "nomPredio")
    private String nombrePredio;
}
