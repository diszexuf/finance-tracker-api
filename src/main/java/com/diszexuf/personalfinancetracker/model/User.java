package com.diszexuf.personalfinancetracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
        schema = "public",
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_email", columnNames = {"email"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();
}
