package com.ph.mireciboph.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ph.mireciboph.Entity.AsociadosEntity;
import com.ph.mireciboph.Entity.DTO.AsociadosDto;
import com.ph.mireciboph.Repositories.AsociadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsociadosService extends CsvParser<AsociadosDto>{
    private final AsociadosRepository asociadosRepository;

    public ResponseEntity<String> logicaInsertado(String archivo) {
        List<AsociadosDto> asociados = parsearCsv(archivo, AsociadosDto.class);

        for (var item : asociados) {
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
    }


}
