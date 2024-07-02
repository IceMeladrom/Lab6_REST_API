package ru.bmstu.Lab6_REST_API.facade;

import ru.bmstu.Lab6_REST_API.dto.PlayerDto;
import ru.bmstu.Lab6_REST_API.entity.Player;
import ru.bmstu.Lab6_REST_API.entity.User;
import ru.bmstu.Lab6_REST_API.exceptions.UserNotFoundException;
import ru.bmstu.Lab6_REST_API.repository.UserRepository;

public class PlayerFacade {


    public static PlayerDto mapToPlayerDto(Player player) {
        return new PlayerDto(
                player.getId(),
                player.getUserLogin(),
                player.getLogin());
    }

    public static Player mapToPlayer(PlayerDto playerDto) {
        Player player = new Player(playerDto.getUserLogin(), playerDto.getLogin());
        player.setId(player.getId());
        return player;
    }
}
