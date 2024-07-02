package ru.bmstu.Lab6_REST_API.facade;

import ru.bmstu.Lab6_REST_API.dto.MapDto;
import ru.bmstu.Lab6_REST_API.entity.MapData;

public class MapFacade {
    public static MapDto mapToMapDto(MapData mapData) {
        return new MapDto(mapData.getId(), mapData.getPlayerLogin());
    }

    public static MapData mapToMap(MapDto mapDto) {
        MapData mapData = new MapData(mapDto.getPlayerLogin());
        mapData.setId(mapData.getId());
        return mapData;
    }
}
