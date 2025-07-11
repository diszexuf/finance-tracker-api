package com.diszexuf.personalfinancetracker.dto.statistic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticSummaryResponseDto {

    @NotBlank(message = "Category name must not be blank")
    private String categoryName;

    @NotNull(message = "Total amount must not be null")
    private BigDecimal totalAmount;
}
