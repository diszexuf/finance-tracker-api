package com.diszexuf.personalfinancetracker.service;

import com.diszexuf.personalfinancetracker.dto.statistic.StatisticBalanceResponseDto;
import com.diszexuf.personalfinancetracker.dto.statistic.StatisticSummaryResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IStatisticService {
    StatisticBalanceResponseDto getCurrentBalance(LocalDate dateFrom, LocalDate dateTo);

    List<StatisticSummaryResponseDto> getCategoryStatistic(LocalDate dateFrom, LocalDate dateTo);
}
