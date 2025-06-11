package com.labvision.labvision;

import com.labvision.labvision.model.User;
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
	public CommandLineRunner demo(UserRepository userRepo) {
		return args -> {
			//if (usuarioRepo.count() == 0) {
				//userRepo.deleteAll();      // apaga todos os usuários
				User u = new User();
				u.setName("Dra. Laura");
				u.setEmail("laura@lab.com");
				u.setPassword("password1234");
				u.setRole("ADMIN");
				userRepo.save(u);
			//}
			userRepo.findAll().forEach(user ->
					System.out.println("Usuário: " + user.getName())
			);
		};
	}
}