package jwtSecurity.example.authService.Service;

import jwtSecurity.example.authService.Dto.LoginDto;
import jwtSecurity.example.authService.Dto.RegisterDto;
import org.hibernate.boot.registry.selector.StrategyRegistration;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    boolean checkUserExistsByEmail(String email);
}