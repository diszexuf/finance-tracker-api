package com.diszexuf.personalfinancetracker.dto.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email, password;
}
