package jwtSecurity.example.authService.Service.Impl;

import jwtSecurity.example.authService.Config.JwtTokenProvider;
import jwtSecurity.example.authService.Dto.LoginDto;
import jwtSecurity.example.authService.Dto.RegisterDto;
import jwtSecurity.example.authService.Model.Role;
import jwtSecurity.example.authService.Model.User;
import jwtSecurity.example.authService.Repository.RoleRepository;
import jwtSecurity.example.authService.Repository.UserRepository;
import jwtSecurity.example.authService.Service.AuthService;
import jwtSecurity.example.authService.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }
    @Override
    public String register(RegisterDto registerDto){
        User user=new User();
        user.setUsername(registerDto.getUsername());
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new DuplicateException("Вы уже были зарегистрированы");
        }
        //Назначение роли
        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) { throw new RuntimeException("Role USER not found"); }
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                registerDto.getUsername(), registerDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

}
