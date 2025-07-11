package com.diszexuf.personalfinancetracker.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
public class RegistrationResponseDto {
    @NotNull(message = "User ID must not be null")
    private UUID userId;

    @NotNull(message = "Email must not be null")
    private String email;

    @NotNull(message = "Username must not be null")
    private String username;
}
