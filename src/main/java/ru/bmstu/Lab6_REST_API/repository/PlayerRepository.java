package ru.bmstu.Lab6_REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.Lab6_REST_API.entity.Player;
import ru.bmstu.Lab6_REST_API.entity.User;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Override
    Optional<Player> findById(Long id);

    Optional<Player> findByLogin(String login);

    List<Player> findByUserLogin(String userLogin);
}
