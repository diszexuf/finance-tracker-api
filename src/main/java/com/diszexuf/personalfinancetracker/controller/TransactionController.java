package com.diszexuf.personalfinancetracker.controller;

import com.diszexuf.personalfinancetracker.dto.transaction.TransactionRequestDto;
import com.diszexuf.personalfinancetracker.dto.transaction.TransactionResponseDto;
import com.diszexuf.personalfinancetracker.service.ITransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TransactionResponseDto createTransaction(
            @Valid @RequestBody TransactionRequestDto dto
    ) {
        return transactionService.createTransaction(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TransactionResponseDto> getAllTransactions(
            @RequestParam(required = false) LocalDate dateFrom,
            @RequestParam(required = false) LocalDate dateTo,
            @RequestParam UUID categoryId
    ) {
        return transactionService.getAllTransactions(dateFrom, dateTo, categoryId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TransactionResponseDto getTransaction(
            @PathVariable(value = "id") UUID id
    ) {
        return transactionService.getTransaction(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TransactionResponseDto updateTransaction(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody TransactionRequestDto dto
            ) {
        return transactionService.updateTransaction(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(
            @PathVariable(value = "id") UUID id
    ) {
        transactionService.deleteTransaction(id);
    }
}
