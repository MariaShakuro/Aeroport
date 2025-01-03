package jwtSecurity.example.authService;

import jwtSecurity.example.authService.Model.Role;
import jwtSecurity.example.authService.Model.User;
import jwtSecurity.example.authService.Repository.RoleRepository;
import jwtSecurity.example.authService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Проверка существования ролей перед их созданием
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");

            Role userRole = new Role();
            userRole.setName("ROLE_USER");

            roleRepository.saveAll(Arrays.asList(adminRole, userRole));
        }

        // Создание пользователя с ролью ADMIN
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");

            User admin = new User();
            admin.setEmail("admin@example.com");
            admin.setName("Admin");
            admin.setPassword("admin123");
            admin.setUsername("admin");
            admin.setRoles(new HashSet<>(Collections.singletonList(adminRole)));

            userRepository.save(admin);
        }
    }
}

