package com.ph.mireciboph.Controllers;

import com.ph.mireciboph.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/import")
public class ImportsController {

    @Autowired
    private PersonasService personasService;
    @Autowired
    private PrediosService prediosService;
    @Autowired
    private RecibosService recibosService;
    @Autowired
    private AsociadosService asociadosService;
    @Autowired
    private CiudadesService ciudadesService;
    @Autowired
    private ConjuntosService conjuntosService;

    @PostMapping("/asociados")
    public ResponseEntity<String> importarAsociados(@RequestParam("file") MultipartFile file) {
        return asociadosService.logicaInsertado(file);
    }

    @PostMapping("/ciudades/{nombreCiudad}")
    public ResponseEntity<String> importarCiudades(@PathVariable String nombreCiudad) {
        return ciudadesService.crearCiudad(nombreCiudad);
    }

    @PostMapping("/conjuntos")
    public ResponseEntity<String> importarConjuntos(@RequestParam("file") MultipartFile file) {
        return conjuntosService.guardarDatos(file);
    }

    @PostMapping("/personas")
    public ResponseEntity<String> importarPersonas(@RequestParam("file") MultipartFile file) {
        return personasService.guardarDatos(file);
    }

    @PostMapping("/predios")
    public ResponseEntity<String> importarPredios(@RequestParam("file") MultipartFile file) {
        return prediosService.guardarDatos(file);
    }

    @PostMapping("/recibos")
    public ResponseEntity<String> importarRecibos(@RequestParam("file") MultipartFile file) {
        return recibosService.guardarDatos(file);
    }
}

