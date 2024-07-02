package ru.bmstu.Lab6_REST_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.Lab6_REST_API.dto.StatisticDto;
import ru.bmstu.Lab6_REST_API.entity.MapData;
import ru.bmstu.Lab6_REST_API.entity.Statistic;
import ru.bmstu.Lab6_REST_API.exceptions.PlayerNotFoundException;
import ru.bmstu.Lab6_REST_API.facade.MapFacade;
import ru.bmstu.Lab6_REST_API.facade.StatisticFacade;
import ru.bmstu.Lab6_REST_API.repository.MapRepository;
import ru.bmstu.Lab6_REST_API.repository.PlayerRepository;
import ru.bmstu.Lab6_REST_API.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public StatisticDto create(StatisticDto statisticDto) {
        playerRepository.findByLogin(statisticDto.getPlayerLogin()).orElseThrow(PlayerNotFoundException::new);
        statisticRepository.findByPlayerLogin(statisticDto.getPlayerLogin()).stream().findAny().map(statistic -> {
            if(statistic.getGameName().equals(statisticDto.getGameName()))
                throw new RuntimeException("Statistics for this game and for this user already exist.");
            return null;
        });


        Statistic statistic = StatisticFacade.mapToStatistic(statisticDto);
        statisticRepository.save(statistic);
        return StatisticFacade.mapToStatisticDto(statistic);
    }

    @Override
    public List<StatisticDto> readAll() {
        List<StatisticDto> statisticDtos = new ArrayList<>();
        for (Statistic statistic : statisticRepository.findAll())
            statisticDtos.add(StatisticFacade.mapToStatisticDto(statistic));

        return statisticDtos;
    }

    @Override
    public List<StatisticDto> read(String playerLogin) {
        playerLogin = playerLogin.replaceAll("[\\r\\n]", "");
        playerRepository.findByLogin(playerLogin).orElseThrow(PlayerNotFoundException::new);

        List<StatisticDto> statisticDtos = new ArrayList<>();
        for (Statistic statistic : statisticRepository.findByPlayerLogin(playerLogin))
            statisticDtos.add(StatisticFacade.mapToStatisticDto(statistic));

        return statisticDtos;
    }

    @Override
    public StatisticDto update(Long id, StatisticDto statisticDto) {
        return null;
    }

    @Override
    public boolean delete(String playerLogin) {
        return false;
    }
}
