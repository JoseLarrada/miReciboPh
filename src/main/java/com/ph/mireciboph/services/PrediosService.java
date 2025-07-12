package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.Predios;
import com.ph.mireciboph.Entity.PrediosEntity;
import com.ph.mireciboph.Repositories.PrediosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrediosService extends CsvParser<Predios> {

    private final PrediosRepository repository;

    public ResponseEntity<String> guardarDatos(MultipartFile archivo) {
        try {
            Reader reader = new InputStreamReader(archivo.getInputStream(), StandardCharsets.UTF_8);
            List<Predios> prediosParseados = parsearCsv(reader, Predios.class);

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

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al leer el archivo CSV");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al procesar los datos: " + e.getMessage());
        }
    }

    private PrediosEntity actualizarPredio(PrediosEntity existente, Predios dto) {
        existente.setCodigoConjunto(new BigDecimal(dto.getCodConjunto()));
        existente.setNombrePredio(dto.getNomPredio());
        return existente;
    }
}

