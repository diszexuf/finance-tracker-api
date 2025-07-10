package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequest;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponse;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequest;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponse;
import com.diszexuf.personalfinancetracker.model.User;
import com.diszexuf.personalfinancetracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) {
        // todo: add mapper
        User user = userRepository.save(
                User.builder()
                        .email(registrationRequest.getEmail())
                        .password(registrationRequest.getPassword())
                        .username(registrationRequest.getUsername())
                        .build()
        );

        return RegistrationResponse.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Override
    public AuthResponse authUser(AuthRequest authRequest) {
        // later
        return new AuthResponse();
    }
}
