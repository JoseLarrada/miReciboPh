package com.ph.mireciboph.Entity.DTO;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecibosDto {
    @CsvBindByName(column = "codPredio")
    private BigDecimal codPredio;
    @CsvBindByName(column = "fecha")
    private Date fecha;
    @CsvBindByName(column = "campo01")
    private BigDecimal campo01;
    @CsvBindByName(column = "campo02")
    private BigDecimal campo02;
    @CsvBindByName(column = "campo03")
    private BigDecimal campo03;
    @CsvBindByName(column = "campo04")
    private BigDecimal campo04;
    @CsvBindByName(column = "campo05")
    private BigDecimal campo05;
    @CsvBindByName(column = "campo06")
    private BigDecimal campo06;
    @CsvBindByName(column = "campo07")
    private BigDecimal campo07;
    @CsvBindByName(column = "campo08")
    private BigDecimal campo08;
    @CsvBindByName(column = "campo09")
    private BigDecimal campo09;
    @CsvBindByName(column = "campo10")
    private BigDecimal campo10;
}
