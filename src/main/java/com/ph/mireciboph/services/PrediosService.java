package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.Predios;
import com.ph.mireciboph.Entity.DTO.ReciboInfoDTO;
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
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public ReciboInfoDTO obtenerDatosPorReferencia(String referencia) {
        return repository.buscarPorReferencia(referencia)
                .orElseThrow(() -> new RuntimeException("No se encontraron datos para la referencia: " + referencia));
    }

    public Map<String, Object> procesarDatosRecibo(ReciboInfoDTO dto) {
        Map<String, Object> datos = new HashMap<>();

        // Sumar todos los campos (null-safe)
        BigDecimal[] campos = {
                dto.getCampo03(), dto.getCampo04(),
                dto.getCampo05(), dto.getCampo06(), dto.getCampo07(),
                dto.getCampo08(), dto.getCampo09(), dto.getCampo10()
        };

        for (int i = 0; i < campos.length; i++) {
            System.out.println(campos[i]);
        }

        BigDecimal total = Arrays.stream(campos)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total calculado: " + total);

        // Descuento fijo de 100
        BigDecimal descuentoFijo = new BigDecimal("10000");


        // Fecha formateada (ej: Julio 12 de 2025)
        LocalDate fecha = dto.getFecha().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("MMMM d 'de' yyyy", new Locale("es", "ES")));


        LocalDate fechaLimite = LocalDate.of(fecha.getYear(), fecha.getMonth(), 21);
        String fechaLimiteFormateada = fechaLimite.format(DateTimeFormatter.ofPattern("d 'de' MMMM", new Locale("es", "ES")));

        // Total con descuentos
        BigDecimal totalConDescuento = total.subtract(descuentoFijo);

        // Agregar datos al map
        datos.put("total", total);
        datos.put("pagoPronto", totalConDescuento);
        datos.put("fecha", fechaFormateada);
        datos.put("fechaLimite", fechaLimiteFormateada);

        return datos;
    }

}

