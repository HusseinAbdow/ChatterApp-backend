package com.ChatterApp.services;
import java.util.HashSet;
import org.springframework.stereotype.Service;

import com.ChatterApp.Repositories.RoleRepository;
import com.ChatterApp.Repositories.UserRepository;
import com.ChatterApp.models.ApplicationUser;
import com.ChatterApp.models.Role;

import jakarta.transaction.Transactional;

@Service
@Transactional
// youtuber mentioned @Transactional what is this what is it usually used for
public class UserService {
	
	
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
	
    
 
   public UserService(UserRepository userRepo, RoleRepository roleRepo) {
	     this.userRepo = userRepo;
	     this.roleRepo = roleRepo;
   }
   
   

   public ApplicationUser registerUser(ApplicationUser user) {
       // Initialize authorities if null
       if (user.getAuthorities() == null) {
           user.setAuthorities(new HashSet<>()); //an empty hashset does not return null. its a valid object with no elements
       }

       // Safely get or create USER role
       Role userRole = roleRepo.findByAuthority("USER")  // checks if a "USER" role exists in the DB
           .orElseGet(() -> roleRepo.save(new Role("USER")));

       // Add role to user
       user.getAuthorities().add(userRole);
       
       return userRepo.save(user);
   }
}