package com.diszexuf.personalfinancetracker.controller;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponseDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponseDto;
import com.diszexuf.personalfinancetracker.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService IAuthService;

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RegistrationResponseDto registerUser(
            @Valid @RequestBody RegistrationRequestDto registrationRequestDto
    ) {
        RegistrationResponseDto registrationResponseDto = IAuthService.registerUser(registrationRequestDto);
        return registrationResponseDto;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public AuthResponseDto loginUser(
            @Valid @RequestBody AuthRequestDto authRequestDto
    ) {
        AuthResponseDto authResponseDto = IAuthService.authUser(authRequestDto);
        return authResponseDto;
    }
}
