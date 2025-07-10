package com.ph.mireciboph.Entity.DTO;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonasDto {
    @CsvBindByName(column = "documento")
    private String documento;
    @CsvBindByName(column = "nomPersona")
    private String nomPersona;
    @CsvBindByName(column = "password")
    private String password;
}
