package ru.bmstu.Lab6_REST_API.services;

import ru.bmstu.Lab6_REST_API.dto.PlayerDto;
import ru.bmstu.Lab6_REST_API.dto.UserDto;

import java.util.List;

public interface PlayerService {
    PlayerDto create(PlayerDto playerDto);

    List<PlayerDto> readAll();

    PlayerDto read(String username);

    PlayerDto update(Long id, PlayerDto playerDto);

    boolean delete(String username);
}
