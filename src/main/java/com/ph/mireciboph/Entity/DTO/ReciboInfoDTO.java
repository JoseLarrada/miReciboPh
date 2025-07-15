package com.ph.mireciboph.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@Data
public class ReciboInfoDTO {
    private String referencia;         // refPago
    private String nombrePredio;       // nomPredio
    private Date fecha;           // fecha recibo
    private BigDecimal campo02;
    private BigDecimal campo03;
    private BigDecimal campo04;
    private BigDecimal campo05;
    private BigDecimal campo06;
    private BigDecimal campo07;
    private BigDecimal campo08;
    private BigDecimal campo09;
    private BigDecimal campo10;
    private String nombrePersona;      // nomPersona
    private String concepto01;         // concepto01 del conjunto

    public ReciboInfoDTO(String referencia, String nombrePredio, Date fecha,
                         BigDecimal campo02, BigDecimal campo03, BigDecimal campo04,
                         BigDecimal campo05, BigDecimal campo06, BigDecimal campo07,
                         BigDecimal campo08, BigDecimal campo09,BigDecimal campo10,
                         String nombrePersona, String concepto01) {
        this.referencia = referencia;
        this.nombrePredio = nombrePredio;
        this.fecha = fecha;
        this.campo02 = campo02;
        this.campo03 = campo03;
        this.campo04 = campo04;
        this.campo05 = campo05;
        this.campo06 = campo06;
        this.campo07 = campo07;
        this.campo08 = campo08;
        this.campo09 = campo09;
        this.campo10 = campo10;
        this.nombrePersona = nombrePersona;
        this.concepto01 = concepto01;
    }
}
