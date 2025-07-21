package com.diszexuf.personalfinancetracker.dto.auth;

import lombok.Data;

@Data
public class UserCredentialsDto {
    private String email;
    private String password;
}
