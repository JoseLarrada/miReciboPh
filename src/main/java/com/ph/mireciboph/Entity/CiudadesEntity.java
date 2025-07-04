package com.ph.mireciboph.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "ciudades")
public class CiudadesEntity {
    @Id
    @Column(name = "codCiudad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal codigoCiudad;
    @Column(name = "nomCiudad")
    private String nombreCiudad;
}
