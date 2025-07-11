package com.diszexuf.personalfinancetracker.dto.transaction;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TransactionResponseDto {
    @NotNull(message = "ID must not be null")
    private UUID id;

    @NotNull(message = "amount must not be null")
    private BigDecimal amount;

    private String description;

    @NotNull(message = "Date must not be null")
    private LocalDate date;

    @NotNull(message = "Category ID must not be null")
    private UUID categoryId;
}
