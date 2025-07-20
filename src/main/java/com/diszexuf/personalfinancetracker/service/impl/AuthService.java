package com.diszexuf.personalfinancetracker.service.impl;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponseDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponseDto;
import com.diszexuf.personalfinancetracker.exception.UserAlreadyExistsException;
import com.diszexuf.personalfinancetracker.exception.UserNotFoundException;
import com.diszexuf.personalfinancetracker.mapper.UserMapper;
import com.diszexuf.personalfinancetracker.model.User;
import com.diszexuf.personalfinancetracker.repository.UserRepository;
import com.diszexuf.personalfinancetracker.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public RegistrationResponseDto registerUser(RegistrationRequestDto dto) {
        log.info("Register user use-case");

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = userRepository.save(userMapper.mapToEntity(dto));

        log.info("Register user use-case executed successfully");
        return userMapper.mapToDto(user);
    }

    @Override
    @Transactional
    public AuthResponseDto authUser(AuthRequestDto dto) {
        log.info("Auth user use-case");

        if (!userRepository.existsByEmail(dto.getEmail())) {
            throw new UserNotFoundException("User not found");
        }

        log.info("Auth user use-case executed successfully");
        return new AuthResponseDto();
    }
}
