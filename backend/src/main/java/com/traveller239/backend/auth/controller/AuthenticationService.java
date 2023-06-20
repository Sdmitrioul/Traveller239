package com.traveller239.backend.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveller239.backend.auth.config.jwt.JwtService;
import com.traveller239.backend.auth.controller.entities.AuthenticationRequest;
import com.traveller239.backend.auth.controller.entities.AuthenticationResponse;
import com.traveller239.backend.auth.controller.entities.RegisterRequest;
import com.traveller239.backend.auth.controller.entities.UserResponse;
import com.traveller239.backend.auth.token.Token;
import com.traveller239.backend.auth.token.TokenRepository;
import com.traveller239.backend.auth.token.TokenType;
import com.traveller239.backend.auth.user.Role;
import com.traveller239.backend.auth.user.User;
import com.traveller239.backend.auth.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        final User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .telegramHandle(request.getTelegramHandle())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        final User savedUser = repository.save(user);
        final String jwtToken = jwtService.generateJwtToken(user);
        final String refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse
                .builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(UserResponse.createUserResponse(savedUser))
                .build();
    }

    private void saveUserToken(User user, String token) {
        final Token savingtToken = Token
                .builder()
                .user(user)
                .token(token)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(savingtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getTelegramHandle(),
                        request.getPassword()
                )
        );

        var user = repository.findByTelegramHandle(request.getTelegramHandle())
                .orElseThrow();

        var jwtToken = jwtService.generateJwtToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(UserResponse.createUserResponse(user))
                .build();
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidUserTokens(user.getId());

        if (validUserTokens.isEmpty()) {
            return;
        }

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByTelegramHandle(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateJwtToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
