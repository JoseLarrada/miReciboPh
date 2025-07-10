package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.PersonasDto;
import com.ph.mireciboph.Entity.PersonasEntity;
import com.ph.mireciboph.Repositories.PersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonasService extends CsvParser<PersonasDto> {

    private final PersonasRepository repository;

    public ResponseEntity<String> guardarDatos(String archivo) {
        List<PersonasDto> personasParseadas = parsearCsv(archivo, PersonasDto.class);

        for (var item : personasParseadas) {
            Optional<PersonasEntity> persona = repository.findByDocumento(item.getDocumento());

            if (persona.isEmpty()) {
                PersonasEntity nuevaPersona = PersonasEntity.builder()
                        .documento(item.getDocumento())
                        .nombrePersona(item.getNomPersona())
                        .contrasena(item.getPassword())
                        .build();
                repository.save(nuevaPersona);
            } else {
                PersonasEntity personaExistente = actualizarPersona(persona.get(), item);
                repository.save(personaExistente);
            }
        }

        return ResponseEntity.ok("Datos de personas procesados correctamente");
    }

    private PersonasEntity actualizarPersona(PersonasEntity existente, PersonasDto dto) {
        existente.setNombrePersona(dto.getNomPersona());
        existente.setContrasena(dto.getPassword());
        return existente;
    }
}

