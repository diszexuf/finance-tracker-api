package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.auth.AuthRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.AuthResponseDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationRequestDto;
import com.diszexuf.personalfinancetracker.dto.auth.RegistrationResponseDto;

public interface IAuthService {
    RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto);

    AuthResponseDto authUser(AuthRequestDto authRequestDto);
}
