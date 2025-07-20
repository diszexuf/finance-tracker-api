package com.diszexuf.personalfinancetracker.service.impl;

import com.diszexuf.personalfinancetracker.dto.transaction.TransactionRequestDto;
import com.diszexuf.personalfinancetracker.dto.transaction.TransactionResponseDto;
import com.diszexuf.personalfinancetracker.mapper.TransactionMapper;
import com.diszexuf.personalfinancetracker.model.Transaction;
import com.diszexuf.personalfinancetracker.repository.TransactionRepository;
import com.diszexuf.personalfinancetracker.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public TransactionResponseDto createTransaction(TransactionRequestDto dto) {
        log.info("Create transaction use-case");

        Transaction transaction = transactionRepository.save(transactionMapper.mapToEntity(dto));

        log.info("Create transaction use-case executed successfully");

        return transactionMapper.mapToDto(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionResponseDto> getAllTransactions(LocalDate dateFrom, LocalDate dateTo, UUID categoryId) {
        log.info("Get all transactions use-case");

        List<Transaction> transactions;
        if (dateFrom == null) dateFrom = LocalDate.now().withDayOfMonth(1);
        if (dateTo == null) dateTo = LocalDate.now();

        if (categoryId == null)
            transactions = transactionRepository.findAllByDateBetween(dateFrom, dateTo);
        else
            transactions = transactionRepository.findAllByDateBetweenAndCategoryId(dateFrom, dateTo, categoryId);

        log.info("Get all transactions use-case executed successfully");
        return transactionMapper.mapToDtos(transactions);
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionResponseDto getTransaction(UUID id) {
        log.info("Get transaction use-case");

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found"));

        log.info("Get transaction use-case executed successfully");
        return transactionMapper.mapToDto(transaction);
    }

    @Override
    @Transactional
    public TransactionResponseDto updateTransaction(UUID id, TransactionRequestDto dto) {
        log.info("Update transaction use-case");

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found"));
        transactionMapper.updateTransactionFromDto(dto, transaction);
        Transaction updatedTransaction = transactionRepository.save(transaction);

        log.info("Update transaction use-case executed successfully");
        return transactionMapper.mapToDto(updatedTransaction);
    }

    @Override
    @Transactional
    public void deleteTransaction(UUID id) {
        log.info("Delete transaction use-case");
        transactionRepository.deleteById(id);
        log.info("Delete transaction use-case executed successfully");
    }
}
