package com.ph.mireciboph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "asociados")
public class AsociadosEntity {
    @Id
    @Column(name = "codAsociados")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoAsociados;
    @Column(name = "codPredio")
    private BigDecimal codigoPredio;
    @Column(name = "codPersona")
    private BigDecimal codigoPersona;
    @Column(name = "tipoAsociado")
    private String tipoAsociado;
}
