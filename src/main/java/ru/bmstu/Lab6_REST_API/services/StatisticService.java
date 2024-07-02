package ru.bmstu.Lab6_REST_API.services;

import ru.bmstu.Lab6_REST_API.dto.PlayerDto;
import ru.bmstu.Lab6_REST_API.dto.StatisticDto;

import java.util.List;

public interface StatisticService {
    StatisticDto create(StatisticDto statisticDto);

    List<StatisticDto> readAll();

    List<StatisticDto> read(String playerLogin);

    StatisticDto update(Long id, StatisticDto statisticDto);

    boolean delete(String playerLogin);
}
