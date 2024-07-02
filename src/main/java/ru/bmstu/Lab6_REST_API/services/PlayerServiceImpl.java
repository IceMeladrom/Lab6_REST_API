package ru.bmstu.Lab6_REST_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.Lab6_REST_API.dto.PlayerDto;
import ru.bmstu.Lab6_REST_API.entity.Player;
import ru.bmstu.Lab6_REST_API.exceptions.PlayerNotFoundException;
import ru.bmstu.Lab6_REST_API.exceptions.UserNotFoundException;
import ru.bmstu.Lab6_REST_API.facade.PlayerFacade;
import ru.bmstu.Lab6_REST_API.repository.PlayerRepository;
import ru.bmstu.Lab6_REST_API.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, UserRepository userRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PlayerDto create(PlayerDto playerDto) {
        userRepository.findByLogin(playerDto.getUserLogin()).orElseThrow(UserNotFoundException::new);

        Player player = PlayerFacade.mapToPlayer(playerDto);
        playerRepository.save(player);
        return PlayerFacade.mapToPlayerDto(player);
    }

    @Override
    public List<PlayerDto> readAll() {
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : playerRepository.findAll()) {
            playerDtos.add(PlayerFacade.mapToPlayerDto(player));
        }
        return playerDtos;
    }

    @Override
    public PlayerDto read(String playerLogin) {
        Player player = playerRepository.findByLogin(playerLogin).orElseThrow(PlayerNotFoundException::new);
        return PlayerFacade.mapToPlayerDto(player);
    }

    @Override
    public PlayerDto update(Long id, PlayerDto playerDto) {
        Player player = playerRepository.findById(id).orElseThrow(PlayerNotFoundException::new);
        userRepository.findByLogin(playerDto.getUserLogin()).orElseThrow(UserNotFoundException::new);

        Player newPlayer = PlayerFacade.mapToPlayer(playerDto);
        player.setLogin(newPlayer.getLogin());
        player.setUserLogin(newPlayer.getUserLogin());
        playerRepository.save(player);
        return PlayerFacade.mapToPlayerDto(newPlayer);
    }

    @Override
    public boolean delete(String playerLogin) {
        try {
            Player player = playerRepository.findByLogin(playerLogin).orElseThrow(PlayerNotFoundException::new);
            playerRepository.delete(player);
            return true;
        } catch (PlayerNotFoundException e) {
            return false;
        }
    }
}
