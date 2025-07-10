package com.diszexuf.personalfinancetracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
        schema = "public",
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_name", columnNames = {"name"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, nullable = false)
    private CategoryType type;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions = new ArrayList<>();
}
