package com.diszexuf.personalfinancetracker.controller;

import com.diszexuf.personalfinancetracker.dto.statistic.StatisticBalanceResponseDto;
import com.diszexuf.personalfinancetracker.dto.statistic.StatisticSummaryResponseDto;
import com.diszexuf.personalfinancetracker.service.IStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final IStatisticService statisticService;

    @GetMapping(value = "/balance")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public StatisticBalanceResponseDto getCurrentBalance(
            @RequestParam(required = false) LocalDate dateFrom,
            @RequestParam(required = false) LocalDate dateTo
    ) {
        return statisticService.getCurrentBalance(dateFrom, dateTo);
    }

    @GetMapping(value = "/summary")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<StatisticSummaryResponseDto> getCategoryStatistic(
            @RequestParam(required = false) LocalDate dateFrom,
            @RequestParam(required = false) LocalDate dateTo
    ) {
        return statisticService.getCategoryStatistic(dateFrom, dateTo);
    }

}
