package com.ph.mireciboph.services;

import com.ph.mireciboph.Entity.DTO.PersonasDto;
import com.ph.mireciboph.Entity.PersonasEntity;
import com.ph.mireciboph.Repositories.PersonasRepository;
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
public class PersonasService extends CsvParser<PersonasDto> {

    private final PersonasRepository repository;

    public ResponseEntity<String> guardarDatos(MultipartFile file) {
        try (Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)) {
            List<PersonasDto> personasParseadas = parsearCsv(reader, PersonasDto.class);

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
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el archivo");
        }
    }


    private PersonasEntity actualizarPersona(PersonasEntity existente, PersonasDto dto) {
        existente.setNombrePersona(dto.getNomPersona());
        existente.setContrasena(dto.getPassword());
        return existente;
    }
}

