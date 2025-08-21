package com.ChatterApp.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ChatterApp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // Custom Finder
    Optional<Role> findByAuthority(String authorities);

}
