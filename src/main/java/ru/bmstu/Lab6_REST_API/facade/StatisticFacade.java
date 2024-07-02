package ru.bmstu.Lab6_REST_API.facade;

import ru.bmstu.Lab6_REST_API.dto.StatisticDto;
import ru.bmstu.Lab6_REST_API.entity.Statistic;

public class StatisticFacade {
    public static StatisticDto mapToStatisticDto(Statistic statistic) {
        return new StatisticDto(statistic.getId(), statistic.getPlayerLogin(), statistic.getGameName(), statistic.getIsGameWon());
    }

    public static Statistic mapToStatistic(StatisticDto statisticDto) {
        Statistic statistic = new Statistic(statisticDto.getPlayerLogin(), statisticDto.getGameName(), statisticDto.getIsGameWon());
        statistic.setId(statisticDto.getId());
        return statistic;
    }
}
