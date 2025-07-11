package com.diszexuf.personalfinancetracker.dto.statistic;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticBalanceResponseDto {
    @NotNull(message = "Balance must not be null")
    private BigDecimal balance;
}
