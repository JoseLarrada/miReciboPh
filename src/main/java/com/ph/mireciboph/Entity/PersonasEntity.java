package com.ph.mireciboph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")
public class PersonasEntity {
    @Id
    @Column(name = "codPersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoPersona;
    private String documento;
    @Column(name = "nomPersona")
    private String nombrePersona;
    @Column(name = "password")
    private String contrasena;
}
