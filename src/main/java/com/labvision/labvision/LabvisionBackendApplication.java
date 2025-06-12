package com.labvision.labvision;

import com.labvision.labvision.repository.MeasurementRepository;
import com.labvision.labvision.repository.SampleRepository;
import com.labvision.labvision.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabvisionBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(LabvisionBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			UserRepository userRepo,
			SampleRepository sampleRepo,
			MeasurementRepository measurementRepo) {
		return args -> {
			//if (usuarioRepo.count() == 0) {
			//userRepo.deleteAll();	apaga todos os usuários

			// Criação inicial ‘user’/admin
//			User user = new User();
//			user.setName("Dr. Ana");
//			user.setEmail("ana@lab.com");
//			user.setPassword("password1234");
//			user.setRole("PATOLOGO");
//			user = userRepo.save(user);
//			//userRepo.save(user);
//			//} userRepo.findAll().forEach(user -> System.out.println("Usuário: " + user.getName()));
//			System.out.println("Usuário criado: " + user.getName() + " (ID: " + user.getId() + ")");
//
//			// Criação da amostra para medição
//			Sample sample = new Sample();
//			sample.setUser(user);
//			sample.setPatient("João Pedro");
//			sample.setCollectionDate(LocalDate.now());
//			sample.setTissueType("Tecido - muscular");
//			sample.setNotes("Biopsia de tecido muscular");
//			sample = sampleRepo.save(sample);
//			System.out.println("Amostra criada - ID: " + sample.getId() + " para: " + user.getName());
//
//			// Criação das medidas da amostra
//			Measurement measurement = new Measurement();
//			measurement.setSample(sample);
//			measurement.setWidthMm(12.34f);
//			measurement.setLengthMm(56.78f);
//			measurement.setHeightMm(9.10f);
//			measurement.setTimestamp(LocalDateTime.now());
//			measurement.setImageData(new byte[]{0x00}); // teste de byte
//			measurement = measurementRepo.save(measurement);
//			System.out.println("Amostra criada - ID: " + measurement.getId() + "para: " + sample.getId());
//
//			userRepo.findAll().forEach(u -> System.out.println("User: " + u.getName()));
//			sampleRepo.findAll().forEach(s -> System.out.println("Sample: " + s.getId()));
//			measurementRepo.findAll().forEach(m -> System.out.println("Measurement: " + m.getId()));
		};
	}
}