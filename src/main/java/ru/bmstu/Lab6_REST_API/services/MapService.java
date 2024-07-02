package ru.bmstu.Lab6_REST_API.services;

import ru.bmstu.Lab6_REST_API.dto.MapDto;

import java.util.List;

public interface MapService {
    MapDto create(MapDto mapDto);

    List<MapDto> readAll(String playerLogin);

}
