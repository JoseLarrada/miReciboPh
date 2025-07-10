package com.ph.mireciboph.Entity.DTO;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsociadosDto {
    @CsvBindByName(column = "codPredio")
    private BigDecimal codPredio;
    @CsvBindByName(column = "codPersona")
    private BigDecimal codPersona;
    @CsvBindByName(column = "tipoAsociado")
    private String tipoAsociado;
}
