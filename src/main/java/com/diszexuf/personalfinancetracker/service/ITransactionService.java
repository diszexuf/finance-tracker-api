package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.transaction.TransactionRequestDto;
import com.diszexuf.personalfinancetracker.dto.transaction.TransactionResponseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ITransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto dto);

    List<TransactionResponseDto> getAllTransactions(LocalDate dateFrom, LocalDate dateTo, UUID categoryId);

    TransactionResponseDto getTransaction(UUID id);

    TransactionResponseDto updateTransaction(UUID id, TransactionRequestDto dto);

    void deleteTransaction(UUID id);
}
