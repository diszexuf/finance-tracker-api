package com.diszexuf.personalfinancetracker.service.impl;

import com.diszexuf.personalfinancetracker.dto.statistic.StatisticBalanceResponseDto;
import com.diszexuf.personalfinancetracker.dto.statistic.StatisticSummaryResponseDto;
import com.diszexuf.personalfinancetracker.model.CategoryType;
import com.diszexuf.personalfinancetracker.model.Transaction;
import com.diszexuf.personalfinancetracker.repository.TransactionRepository;
import com.diszexuf.personalfinancetracker.service.IStatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticService implements IStatisticService {

    private final TransactionRepository transactionRepository;

    @Override
    public StatisticBalanceResponseDto getCurrentBalance(LocalDate dateFrom, LocalDate dateTo) {
        log.info("Get current balance use-case");
        if (dateFrom == null) dateFrom = LocalDate.now().withDayOfMonth(1);
        if (dateTo == null) dateTo = LocalDate.now();

        List<Transaction> transactions = transactionRepository.findAllByDateBetween(dateFrom, dateTo);
        if (transactions.isEmpty()) return StatisticBalanceResponseDto.builder()
                .balance(BigDecimal.ZERO)
                .build();

        BigDecimal balance = transactions
                .stream()
                .map(t -> t.getCategory().getType() == CategoryType.INCOME
                        ? t.getAmount()
                        : t.getAmount().negate())
                .reduce(new BigDecimal(0), BigDecimal::add);

        log.info("Get current balance use-case executed successfully");
        return StatisticBalanceResponseDto.builder()
                .balance(balance)
                .build();
    }

    @Override
    public List<StatisticSummaryResponseDto> getCategoryStatistic(LocalDate dateFrom, LocalDate dateTo) {
        log.info("Get category statistic use-case");
        if (dateFrom == null) dateFrom = LocalDate.now().withDayOfMonth(1);
        if (dateTo == null) dateTo = LocalDate.now();

        List<Transaction> transactions = transactionRepository.findAllByDateBetween(dateFrom, dateTo);

        List<StatisticSummaryResponseDto> dtos = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getCategory().getId(),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Transaction::getAmount,
                                BigDecimal::add)))
                .entrySet().stream()
                .map(e -> {
                    String categoryName = transactions.stream()
                            .filter(t -> t.getCategory().getId().equals(e.getKey()))
                            .findFirst()
                            .map(t -> t.getCategory().getName())
                            .orElse("");
                    return new StatisticSummaryResponseDto(categoryName, e.getValue());
                })
                .collect(Collectors.toList());

        log.info("Get category statistic use-case executed successfully");
        return dtos;
    }
}
