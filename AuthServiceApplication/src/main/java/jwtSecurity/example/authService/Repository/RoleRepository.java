package jwtSecurity.example.authService.Repository;

import jwtSecurity.example.authService.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
