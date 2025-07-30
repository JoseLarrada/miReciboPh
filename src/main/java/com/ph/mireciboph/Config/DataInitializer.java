package com.ph.mireciboph.Config;

import com.ph.mireciboph.Entity.PrediosEntity;
import com.ph.mireciboph.Repositories.PrediosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component  // Temporarily disabled
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PrediosRepository prediosRepository;

    @Override
    public void run(String... args) {
        try {
            // Add sample data if the database is empty
            if (prediosRepository.count() == 0) {
                createSamplePredios();
            }
        } catch (Exception e) {
            // Table might not exist yet, or other issues during startup
            System.out.println("Could not initialize sample data: " + e.getMessage());
        }
    }

    private void createSamplePredios() {
        PrediosEntity predio1 = PrediosEntity.builder()
                .codigoConjunto(new BigDecimal(1))
                .referenciaPago("1201")
                .nombrePredio("Torre 1 - Apto 201")
                .build();

        PrediosEntity predio2 = PrediosEntity.builder()
                .codigoConjunto(new BigDecimal(1))
                .referenciaPago("1202")
                .nombrePredio("Torre 1 - Apto 202")
                .build();

        PrediosEntity predio3 = PrediosEntity.builder()
                .codigoConjunto(new BigDecimal(1))
                .referenciaPago("1301")
                .nombrePredio("Torre 1 - Apto 301")
                .build();

        PrediosEntity predio4 = PrediosEntity.builder()
                .codigoConjunto(new BigDecimal(2))
                .referenciaPago("2101")
                .nombrePredio("Torre 2 - Apto 101")
                .build();

        PrediosEntity predio5 = PrediosEntity.builder()
                .codigoConjunto(new BigDecimal(2))
                .referenciaPago("2102")
                .nombrePredio("Torre 2 - Apto 102")
                .build();

        prediosRepository.save(predio1);
        prediosRepository.save(predio2);
        prediosRepository.save(predio3);
        prediosRepository.save(predio4);
        prediosRepository.save(predio5);

        System.out.println("Sample predios data created successfully!");
    }
}