package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.ConjuntosEntity;
import com.ph.mireciboph.Entity.DTO.ConjuntosDto;
import com.ph.mireciboph.Repositories.ConjuntosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConjuntosService extends CsvParser<ConjuntosDto> {
    private final ConjuntosRepository repository;

    public ResponseEntity<String> guardarDatos(String archivo){
        List<ConjuntosDto> conjuntosParseados = parsearCsv(archivo, ConjuntosDto.class);
        for (var item: conjuntosParseados){
            Optional<ConjuntosEntity> conjunto = repository.findByNombreConjunto(item.getNomConjunto());

            if (conjunto.isEmpty()) {
                ConjuntosEntity conjuntosEntity = ConjuntosEntity.builder()
                        .codigoCiudad(item.getCodCiudad())
                        .nombreConjunto(item.getNomConjunto())
                        .primerConcepto(item.getConcepto01())
                        .segundoConcepto(item.getConcepto02())
                        .tercerConcepto(item.getConcepto03())
                        .cuartoConcepto(item.getConcepto04())
                        .quintoConcepto(item.getConcepto05())
                        .sextoConcepto(item.getConcepto06())
                        .build();
                repository.save(conjuntosEntity);
            } else {
                ConjuntosEntity conjuntoExist = getConjuntosEntity(item, conjunto);
                repository.save(conjuntoExist);
            }
        }
        return ResponseEntity.ok("Datos procesados correctamente");
    }

    private static ConjuntosEntity getConjuntosEntity(ConjuntosDto item, Optional<ConjuntosEntity> conjunto) {
        ConjuntosEntity conjuntoExist = conjunto.get();
        conjuntoExist.setCodigoCiudad(item.getCodCiudad());
        conjuntoExist.setNombreConjunto(item.getNomConjunto());
        conjuntoExist.setPrimerConcepto(item.getConcepto01());
        conjuntoExist.setSegundoConcepto(item.getConcepto02());
        conjuntoExist.setTercerConcepto(item.getConcepto03());
        conjuntoExist.setCuartoConcepto(item.getConcepto04());
        conjuntoExist.setQuintoConcepto(item.getConcepto05());
        conjuntoExist.setSextoConcepto(item.getConcepto06());
        return conjuntoExist;
    }

}
