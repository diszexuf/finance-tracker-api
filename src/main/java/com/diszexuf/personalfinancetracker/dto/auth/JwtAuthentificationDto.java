package com.diszexuf.personalfinancetracker.dto.auth;

import lombok.Data;

@Data
public class JwtAuthentificationDto {
    private String token;
    private String refreshToken;
}
