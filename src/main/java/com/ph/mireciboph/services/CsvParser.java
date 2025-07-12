package com.ph.mireciboph.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public abstract class CsvParser<T> {

    public List<T> parsearCsv(Reader reader, Class<T> tipo) {
        try {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(tipo)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear el archivo CSV", e);
        }
    }
}
