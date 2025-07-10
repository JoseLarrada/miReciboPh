package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.CiudadesEntity;
import com.ph.mireciboph.Repositories.CiudadesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CiudadesService {
    private final CiudadesRepository repository;

    public ResponseEntity<String> crearCiudad(String nombreCiudad){
        if (!repository.existsByNombreCiudad(nombreCiudad)){
            CiudadesEntity ciudad = CiudadesEntity.builder()
                    .nombreCiudad(nombreCiudad)
                    .build();
            repository.save(ciudad);
            return ResponseEntity.ok("Ciudad Guardada Correctamente");
        }
        return ResponseEntity.badRequest().body("La ciudad ya existe");
    }

    public ResponseEntity<List<String>> listarCiudades(){
        List<String> ciudades = new ArrayList<>();
        for (var item:repository.findAll()){
            ciudades.add(item.getNombreCiudad());
        }
        return ResponseEntity.ok(ciudades);
    }
}
