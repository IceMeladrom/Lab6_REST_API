package ru.bmstu.Lab6_REST_API.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.Lab6_REST_API.dto.PlayerDto;
import ru.bmstu.Lab6_REST_API.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PutMapping("createPlayerByLogin")
    public ResponseEntity<PlayerDto> create(@RequestBody @Valid PlayerDto playerDto) {
        PlayerDto playerDto1 = playerService.create(playerDto);
        return new ResponseEntity<>(playerDto1, HttpStatus.CREATED);
    }

    @GetMapping("getAllPlayers")
    public ResponseEntity<List<PlayerDto>> read() {
        List<PlayerDto> playerDtos = playerService.readAll();
        if (!playerDtos.isEmpty())
            return new ResponseEntity<>(playerDtos, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("getPlayer/{login}")
    public ResponseEntity<PlayerDto> read(@PathVariable String login) {
        PlayerDto playerDto = playerService.read(login);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }


    @DeleteMapping("deletePlayer/{login}")
    public ResponseEntity<String> delete(@PathVariable String login) {
        if (playerService.delete(login))
            return new ResponseEntity<>("Player " + login + " has been deleted.", HttpStatus.OK);
        return new ResponseEntity<>("Player " + login + " has not been deleted.", HttpStatus.NOT_FOUND);
    }
}
