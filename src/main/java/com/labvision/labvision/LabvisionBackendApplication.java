package com.labvision.labvision;

import com.labvision.labvision.repository.MeasurementRepository;
import com.labvision.labvision.repository.SampleRepository;
import com.labvision.labvision.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Para rodar perfil - dev / prod
@SpringBootApplication
public class LabvisionBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(LabvisionBackendApplication.class, args);
	}
}