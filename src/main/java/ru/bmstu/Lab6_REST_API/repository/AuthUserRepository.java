package ru.bmstu.Lab6_REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.Lab6_REST_API.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
