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
@Table(name = "conjuntos")
public class ConjuntosEntity {
    @Id
    @Column(name = "codConjunto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoConjunto;
    @Column(name = "codCiudad")
    private BigDecimal codigoCiudad;
    @Column(name = "nomConjunto")
    private String nombreConjunto;
    @Column(name = "concepto01")
    private String primerConcepto;
    @Column(name = "concepto02")
    private String segundoConcepto;
    @Column(name = "concepto03")
    private String tercerConcepto;
    @Column(name = "concepto04")
    private String cuartoConcepto;
    @Column(name = "concepto05")
    private String quintoConcepto;
    @Column(name = "concepto06")
    private String sextoConcepto;
}
