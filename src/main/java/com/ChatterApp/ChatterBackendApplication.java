package com.ChatterApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ChatterApp.Repositories.RoleRepository;
import com.ChatterApp.models.ApplicationUser;
import com.ChatterApp.models.Role;
import com.ChatterApp.services.UserService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class ChatterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatterBackendApplication.class, args);
	}
	@Bean
	@Transactional
	CommandLineRunner run(RoleRepository roleRepo,  UserService userService ) {
		return args -> {
			
			roleRepo.save(new Role ("USER"));
			ApplicationUser u = new ApplicationUser();
			
			u.setFirstName("User");
			u.setLastName("Zero");
			
			userService.registerUser(u);
			
		};
	}
}
