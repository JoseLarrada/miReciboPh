package com.ph.mireciboph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "predios")
public class RecibosEntity {
    @Id
    @Column(name = "codRecibo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoRecibo;
    @Column(name = "codPredio")
    private BigDecimal codigoPredio;
    private Date fecha;
    @Column(name = "campo01")
    private BigDecimal primerCampo;
    @Column(name = "campo02")
    private BigDecimal segundoCampo;
    @Column(name = "campo03")
    private BigDecimal tercerCampo;
    @Column(name = "campo04")
    private BigDecimal cuartoCampo;
    @Column(name = "campo05")
    private BigDecimal quintoCampo;
    @Column(name = "campo06")
    private BigDecimal sextoCampo;
    @Column(name = "campo07")
    private BigDecimal septimoCampo;
    @Column(name = "campo08")
    private BigDecimal octavoCampo;
    @Column(name = "campo09")
    private BigDecimal novenoCampo;
    @Column(name = "campo10")
    private BigDecimal decimoCampo;
}
