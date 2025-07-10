package com.ph.mireciboph.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public abstract class CsvParser<T> {

    public List<T> parsearCsv(String archivo, Class<T> tipo) {
        try (Reader reader = new FileReader(archivo)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(tipo)  // El tipo se pasa como parámetro
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Error al parsear el archivo CSV", e);
        }
    }
}
