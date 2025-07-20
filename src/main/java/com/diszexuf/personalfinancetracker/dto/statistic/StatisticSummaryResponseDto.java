package com.diszexuf.personalfinancetracker.dto.statistic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticSummaryResponseDto {

    @NotBlank(message = "Category name must not be blank")
    private String categoryName;

    @NotNull(message = "Total amount must not be null")
    private BigDecimal totalAmount;
}
