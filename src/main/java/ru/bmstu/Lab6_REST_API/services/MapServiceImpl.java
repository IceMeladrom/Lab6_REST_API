package ru.bmstu.Lab6_REST_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.Lab6_REST_API.dto.MapDto;
import ru.bmstu.Lab6_REST_API.entity.MapData;
import ru.bmstu.Lab6_REST_API.entity.Player;
import ru.bmstu.Lab6_REST_API.exceptions.PlayerNotFoundException;
import ru.bmstu.Lab6_REST_API.facade.MapFacade;
import ru.bmstu.Lab6_REST_API.repository.MapRepository;
import ru.bmstu.Lab6_REST_API.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapRepository mapRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public MapDto create(MapDto mapDto) {
        playerRepository.findByLogin(mapDto.getPlayerLogin()).orElseThrow(PlayerNotFoundException::new);
        MapData mapData = MapFacade.mapToMap(mapDto);
        mapRepository.save(mapData);
        return MapFacade.mapToMapDto(mapData);
    }

    @Override
    public List<MapDto> readAll(String playerLogin) {
        List<MapDto> mapDtos = new ArrayList<>();
        for (MapData mapData : mapRepository.findByPlayerLogin(playerLogin)) {
            mapDtos.add(MapFacade.mapToMapDto(mapData));
        }
        return mapDtos;
    }
}
