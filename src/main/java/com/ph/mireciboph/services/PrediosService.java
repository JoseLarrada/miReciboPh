package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.Predios;
import com.ph.mireciboph.Entity.PrediosEntity;
import com.ph.mireciboph.Repositories.PrediosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrediosService extends CsvParser<Predios> {

    private final PrediosRepository repository;

    public ResponseEntity<String> guardarDatos(String archivo) {
        List<Predios> prediosParseados = parsearCsv(archivo, Predios.class);

        for (var item : prediosParseados) {
            Optional<PrediosEntity> predio = repository.findByReferenciaPago(item.getRefPago());

            if (predio.isEmpty()) {
                PrediosEntity nuevoPredio = PrediosEntity.builder()
                        .codigoConjunto(new BigDecimal(item.getCodConjunto()))
                        .referenciaPago(item.getRefPago())
                        .nombrePredio(item.getNomPredio())
                        .build();
                repository.save(nuevoPredio);
            } else {
                PrediosEntity predioExistente = actualizarPredio(predio.get(), item);
                repository.save(predioExistente);
            }
        }

        return ResponseEntity.ok("Datos de predios procesados correctamente");
    }

    private PrediosEntity actualizarPredio(PrediosEntity existente, Predios dto) {
        existente.setCodigoConjunto(new BigDecimal(dto.getCodConjunto()));
        existente.setNombrePredio(dto.getNomPredio());
        return existente;
    }
}

