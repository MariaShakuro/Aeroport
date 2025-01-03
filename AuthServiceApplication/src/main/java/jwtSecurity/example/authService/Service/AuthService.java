package jwtSecurity.example.authService.Service;

import jwtSecurity.example.authService.Dto.LoginDto;
import jwtSecurity.example.authService.Dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}