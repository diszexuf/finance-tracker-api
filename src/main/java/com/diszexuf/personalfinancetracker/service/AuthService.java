package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequest;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponse;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequest;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponse;

public interface AuthService {
    RegistrationResponse registerUser(RegistrationRequest registrationRequest);

    AuthResponse authUser(AuthRequest authRequest);
}
