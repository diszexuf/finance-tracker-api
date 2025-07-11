package com.diszexuf.personalfinancetracker.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class AuthResponseDto {
    @NotNull(message = "Token must not be null")
    private String token;
}
