package ru.bmstu.Lab6_REST_API.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.Lab6_REST_API.dto.StatisticDto;
import ru.bmstu.Lab6_REST_API.services.StatisticService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @PutMapping("createStatPlayer")
    public ResponseEntity<StatisticDto> create(@RequestBody @Valid StatisticDto statisticDto) {
        return new ResponseEntity<>(statisticService.create(statisticDto), HttpStatus.OK);
    }

    @GetMapping("getAllStats")
    public ResponseEntity<List<StatisticDto>> read() {
        List<StatisticDto> statisticDtos = statisticService.readAll();
        if (!statisticDtos.isEmpty())
            return new ResponseEntity<>(statisticDtos, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getStatPlayer/{playerLogin}")
    public ResponseEntity<List<StatisticDto>> read(@PathVariable String playerLogin) {
        List<StatisticDto> statisticDtos = statisticService.read(playerLogin);
        if (!statisticDtos.isEmpty())
            return new ResponseEntity<>(statisticDtos, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
