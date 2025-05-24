package com.ChatterApp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ChatterApp.Repositories.RoleRepository;
import com.ChatterApp.Repositories.UserRepository;
import com.ChatterApp.models.ApplicationUser;
import com.ChatterApp.models.Role;
import com.ChatterApp.services.UserService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ChatterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatterBackendApplication.class, args);
	}
	//THE CODE BELOW THIS(COMMENTED) WAS DONE FIRST TO ADD USER ZERO TO THE DB..I COMMENTED IT OUT TO AVOID COLLISION AFTER MAKING USERSERVICE AND CONTINUED WITH THE CODE BELOW THE COMMENTED PART
//	@Bean
//	@Transactional
//	CommandLineRunner run(RoleRepository roleRepo, UserRepository userRepo) {
//	    return args -> {
//	        // Save role first and ensure it's persisted
//	        Role userRole = roleRepo.saveAndFlush(new Role("USER"));
//	        
//	        // Create user with the role
//	        ApplicationUser user = new ApplicationUser();
//	        user.setFirstName("User");
//	        user.setLastName("Zero");
//	        
//	        // Initialize authorities
//	        Set<Role> authorities = new HashSet<>();
//	        authorities.add(userRole);
//	        user.setAuthorities(authorities);
//	        
//	        // Save user
//	        userRepo.save(user);
//        
//	        // Verify
//	        System.out.println("Created user with ID: " + user.getUserID());
//	    };
//	}
	

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
