package com.diszexuf.personalfinancetracker.repository;

import com.diszexuf.personalfinancetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
}
