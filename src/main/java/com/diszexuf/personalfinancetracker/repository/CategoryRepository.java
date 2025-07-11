package com.diszexuf.personalfinancetracker.repository;

import com.diszexuf.personalfinancetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
