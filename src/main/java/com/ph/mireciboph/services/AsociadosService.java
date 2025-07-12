package com.ph.mireciboph.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ph.mireciboph.Entity.AsociadosEntity;
import com.ph.mireciboph.Entity.DTO.AsociadosDto;
import com.ph.mireciboph.Repositories.AsociadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsociadosService extends CsvParser<AsociadosDto>{
    private final AsociadosRepository asociadosRepository;

    public ResponseEntity<String> logicaInsertado(MultipartFile archivo) {
        try {
            // Usamos un InputStreamReader con codificación UTF-8
            Reader reader = new InputStreamReader(archivo.getInputStream(), StandardCharsets.UTF_8);

            List<AsociadosDto> asociados = parsearCsv(reader, AsociadosDto.class);

            for (AsociadosDto item : asociados) {
                Optional<AsociadosEntity> existenteOpt = asociadosRepository.findByCodigoPredio(item.getCodPredio());

                if (existenteOpt.isEmpty()) {
                    // No existe, se guarda
                    AsociadosEntity nuevo = AsociadosEntity.builder()
                            .codigoPredio(item.getCodPredio())
                            .codigoPersona(item.getCodPersona())
                            .tipoAsociado(item.getTipoAsociado())
                            .build();
                    asociadosRepository.save(nuevo);
                } else {
                    // Ya existe, se actualiza
                    AsociadosEntity existente = existenteOpt.get();
                    existente.setCodigoPersona(item.getCodPersona());
                    existente.setTipoAsociado(item.getTipoAsociado());
                    asociadosRepository.save(existente);
                }
            }

            return ResponseEntity.ok("Archivo procesado correctamente");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al leer el archivo CSV");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al procesar el archivo: " + e.getMessage());
        }
    }



}
