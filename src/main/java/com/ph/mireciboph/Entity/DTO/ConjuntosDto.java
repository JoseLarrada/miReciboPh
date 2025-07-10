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
public class ConjuntosDto {
    @CsvBindByName(column = "codCiudad")
    private BigDecimal codCiudad;
    @CsvBindByName(column = "nomConjunto")
    private String nomConjunto;
    @CsvBindByName(column = "concepto01")
    private String concepto01;
    @CsvBindByName(column = "concepto02")
    private String concepto02;
    @CsvBindByName(column = "concepto03")
    private String concepto03;
    @CsvBindByName(column = "concepto04")
    private String concepto04;
    @CsvBindByName(column = "concepto05")
    private String concepto05;
    @CsvBindByName(column = "concepto06")
    private String concepto06;
}

