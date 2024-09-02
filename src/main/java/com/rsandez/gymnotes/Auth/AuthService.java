package com.rsandez.gymnotes.Auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rsandez.gymnotes.Entities.Role;
import com.rsandez.gymnotes.Entities.User;
import com.rsandez.gymnotes.JWT.JwtService;
import com.rsandez.gymnotes.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    // public AuthResponse login(LoginRequest request) {
    //     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    //     UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
    //     String token=jwtService.getToken(user);
    //     return AuthResponse.builder()
    //         .token(token)
    //         .build();

    // }

    public AuthResponse login(LoginRequest request) {
    // Autenticar al usuario
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
    );

    // Obtener los detalles del usuario desde la base de datos
    User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

    // Generar el token JWT
    String token = jwtService.getToken(user);

    // Construir y devolver la respuesta incluyendo la información del usuario
    return new AuthResponse(token, user.getId(), user.getUsername());
}

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()) )
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .country(request.getCountry())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }

}
