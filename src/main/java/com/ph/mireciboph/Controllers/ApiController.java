package com.ph.mireciboph.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        Map<String, Object> response = new HashMap<>();
        
        // Simple authentication logic - in production, this should be properly implemented
        String username = credentials.get("username");
        String password = credentials.get("password");
        
        // For demo purposes, accept any username/password
        if (username != null && password != null && !username.trim().isEmpty() && !password.trim().isEmpty()) {
            response.put("success", true);
            response.put("message", "Login exitoso");
            response.put("user", Map.of("username", username));
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/predios")
    public ResponseEntity<List<Map<String, Object>>> getPredios() {
        // For demo purposes, return hard-coded data since database creation is having issues
        List<Map<String, Object>> prediosFormatted = List.of(
            Map.of("id", 1, "nombre", "Torre 1 - Apto 201", "referenciaPago", "1201"),
            Map.of("id", 2, "nombre", "Torre 1 - Apto 202", "referenciaPago", "1202"),
            Map.of("id", 3, "nombre", "Torre 1 - Apto 301", "referenciaPago", "1301"),
            Map.of("id", 4, "nombre", "Torre 2 - Apto 101", "referenciaPago", "2101"),
            Map.of("id", 5, "nombre", "Torre 2 - Apto 102", "referenciaPago", "2102")
        );
            
        return ResponseEntity.ok(prediosFormatted);
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getCurrentUser(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        if (authentication != null && authentication.isAuthenticated()) {
            response.put("username", authentication.getName());
            response.put("authenticated", true);
        } else {
            response.put("authenticated", false);
        }
        return ResponseEntity.ok(response);
    }
}