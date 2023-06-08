package com.lerob.training.patientsmvc;

import com.lerob.training.patientsmvc.entities.Patient;
import com.lerob.training.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Borel", new Date(), false, 15 ));
            patientRepository.save(new Patient(null, "Kevin", new Date(), true, 18 ));
            patientRepository.save(new Patient(null, "Franck", new Date(), false, 13 ));
            patientRepository.save(new Patient(null, "John", new Date(), true, 9 ));

            patientRepository.findAll().forEach(patient -> System.out.println(patient.getNom()));
        };
    }

}
