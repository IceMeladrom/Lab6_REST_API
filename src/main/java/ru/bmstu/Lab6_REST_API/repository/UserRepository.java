package ru.bmstu.Lab6_REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.Lab6_REST_API.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);
}
