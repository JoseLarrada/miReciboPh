package com.ph.mireciboph.Entity.DTO;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Predios {
    @CsvBindByName(column = "codConjunto")
    private BigInteger codConjunto;
    @CsvBindByName(column = "refPago")
    private String refPago;
    @CsvBindByName(column = "nomPredio")
    private String nomPredio;
}
