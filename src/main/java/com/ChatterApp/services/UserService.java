package com.ChatterApp.services;

import java.util.HashSet;
import org.springframework.stereotype.Service;

import com.ChatterApp.Repositories.RoleRepository;
import com.ChatterApp.Repositories.UserRepository;
import com.ChatterApp.exceptions.EmailAlreadyTakenException;
import com.ChatterApp.models.ApplicationUser;
import com.ChatterApp.models.RegistrationObject;
import com.ChatterApp.models.Role;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

  
    // Dependencies
  
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

 
    // Constructor Injection
    
    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

   
    // User Registration Logic
    
    public ApplicationUser registerUser(RegistrationObject ro) {
        // Prevent duplicate emails
        if (userRepo.findByEmail(ro.getEmail()).isPresent()) {
            throw new EmailAlreadyTakenException();
        }

        // Build new ApplicationUser
        ApplicationUser user = new ApplicationUser();
        user.setFirstName(ro.getFirstName());
        user.setLastName(ro.getLastName());
        user.setEmail(ro.getEmail());
        user.setDateOfBirth(ro.getDob());

        // Generate username
        String username = user.getFirstName() + user.getLastName();
        String tempName = "";
        boolean userNameTaken = true;

        while (userNameTaken) {
            tempName = generateUsername(username);
            if (userRepo.findByUsername(tempName).isEmpty()) {
                userNameTaken = false;
            }
        }
        user.setUsername(tempName);

        // Initialize authorities if null
        if (user.getAuthorities() == null) {
            user.setAuthorities(new HashSet<>()); 
        }

        // Safely get or create USER role
        Role userRole = roleRepo.findByAuthority("USER")
            .orElseGet(() -> roleRepo.save(new Role("USER")));

        // Assign role
        user.getAuthorities().add(userRole);

        try {
            return userRepo.save(user);
        } catch (Exception e) {
            throw new EmailAlreadyTakenException();
        }
    }

  
    // Username Generator
  
    private String generateUsername(String name) {
        long generatedNumber = (long) Math.floor(Math.random() * 1_000_000_000);
        return name + generatedNumber;
    }
}
