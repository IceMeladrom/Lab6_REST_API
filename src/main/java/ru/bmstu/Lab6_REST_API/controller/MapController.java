package ru.bmstu.Lab6_REST_API.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.Lab6_REST_API.dto.MapDto;
import ru.bmstu.Lab6_REST_API.services.MapService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MapController {
    @Autowired
    private MapService mapService;


    @PutMapping("createMapPlayer")
    public ResponseEntity<MapDto> create(@RequestBody @Valid MapDto mapDto) {
        return new ResponseEntity<>(mapService.create(mapDto), HttpStatus.OK);
    }

    @GetMapping("getMapPlayer/{playerLogin}")
    public ResponseEntity<List<MapDto>> read(@PathVariable String playerLogin) {
        List<MapDto> mapDtos = mapService.readAll(playerLogin);
        if (!mapDtos.isEmpty())
            return new ResponseEntity<>(mapDtos, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
