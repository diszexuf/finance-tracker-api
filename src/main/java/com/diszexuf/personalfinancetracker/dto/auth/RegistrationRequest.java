package com.diszexuf.personalfinancetracker.dto.auth;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email, password, username;
}
