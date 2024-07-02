package ru.bmstu.Lab6_REST_API.services;

import ru.bmstu.Lab6_REST_API.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto user);

    List<UserDto> readAll();

    UserDto read(String login);

    boolean update(Long id, UserDto user);

    boolean delete(String login);
}
