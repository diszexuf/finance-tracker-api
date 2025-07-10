package com.diszexuf.personalfinancetracker.controller;

import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequest;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponse;
import com.diszexuf.personalfinancetracker.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(RegistrationRequest registrationRequest) {
        RegistrationResponse registrationResponse = authService.registerUser(registrationRequest);
        return ResponseEntity.ok(registrationResponse);
    }
}
