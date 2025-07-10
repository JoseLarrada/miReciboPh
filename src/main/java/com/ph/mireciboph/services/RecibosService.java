package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.RecibosDto;
import com.ph.mireciboph.Entity.RecibosEntity;
import com.ph.mireciboph.Repositories.RecibosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecibosService extends CsvParser<RecibosDto> {

    private final RecibosRepository repository;

    public ResponseEntity<String> guardarDatos(String archivo) {
        List<RecibosDto> recibosParseados = parsearCsv(archivo, RecibosDto.class);

        for (var item : recibosParseados) {
            Optional<RecibosEntity> recibo = repository.findByCodigoPredioAndFecha(item.getCodPredio(), item.getFecha());

            if (recibo.isEmpty()) {
                RecibosEntity nuevo = mapearNuevo(item);
                repository.save(nuevo);
            } else {
                RecibosEntity actualizado = actualizarRecibo(recibo.get(), item);
                repository.save(actualizado);
            }
        }

        return ResponseEntity.ok("Datos de recibos procesados correctamente");
    }

    private RecibosEntity mapearNuevo(RecibosDto dto) {
        return RecibosEntity.builder()
                .codigoPredio(dto.getCodPredio())
                .fecha(dto.getFecha())
                .primerCampo(dto.getCampo01())
                .segundoCampo(dto.getCampo02())
                .tercerCampo(dto.getCampo03())
                .cuartoCampo(dto.getCampo04())
                .quintoCampo(dto.getCampo05())
                .sextoCampo(dto.getCampo06())
                .septimoCampo(dto.getCampo07())
                .octavoCampo(dto.getCampo08())
                .novenoCampo(dto.getCampo09())
                .decimoCampo(dto.getCampo10())
                .build();
    }

    private RecibosEntity actualizarRecibo(RecibosEntity entity, RecibosDto dto) {
        entity.setPrimerCampo(dto.getCampo01());
        entity.setSegundoCampo(dto.getCampo02());
        entity.setTercerCampo(dto.getCampo03());
        entity.setCuartoCampo(dto.getCampo04());
        entity.setQuintoCampo(dto.getCampo05());
        entity.setSextoCampo(dto.getCampo06());
        entity.setSeptimoCampo(dto.getCampo07());
        entity.setOctavoCampo(dto.getCampo08());
        entity.setNovenoCampo(dto.getCampo09());
        entity.setDecimoCampo(dto.getCampo10());
        return entity;
    }
}

