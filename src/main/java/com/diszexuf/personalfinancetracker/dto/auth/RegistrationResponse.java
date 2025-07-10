package com.diszexuf.personalfinancetracker.dto.auth;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse {
    private UUID userId;
    private String email, username;
}
