package com.diszexuf.personalfinancetracker.repository;

import com.diszexuf.personalfinancetracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findAllByDateBetween(LocalDate dateAfter, LocalDate dateBefore);

    List<Transaction> findAllByDateBetweenAndCategoryId(LocalDate dateAfter, LocalDate dateBefore, UUID CategoryId);
}
