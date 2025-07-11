package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponseDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponseDto;
import com.diszexuf.personalfinancetracker.model.User;
import com.diszexuf.personalfinancetracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IAuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;

    @Override
    public RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto) {
        // todo: add mapper
        User user = userRepository.save(
                User.builder()
                        .email(registrationRequestDto.getEmail())
                        .password(registrationRequestDto.getPassword())
                        .username(registrationRequestDto.getUsername())
                        .build()
        );

        return RegistrationResponseDto.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Override
    public AuthResponseDto authUser(AuthRequestDto authRequestDto) {
        // later
        return new AuthResponseDto();
    }
}
