package ru.bmstu.Lab6_REST_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.Lab6_REST_API.dto.UserDto;
import ru.bmstu.Lab6_REST_API.entity.User;
import ru.bmstu.Lab6_REST_API.exceptions.UserNotFoundException;
import ru.bmstu.Lab6_REST_API.facade.UserFacade;
import ru.bmstu.Lab6_REST_API.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = UserFacade.mapToUser(userDto);
        userRepository.save(user);
        return UserFacade.mapToUserDto(user);
    }

    @Override
    public List<UserDto> readAll() {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepository.findAll())
            userDtos.add(UserFacade.mapToUserDto(user));
        return userDtos;
    }

    @Override
    public UserDto read(String login) {
        return UserFacade.mapToUserDto(userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public boolean update(Long id, UserDto userDto) {
        return false;
    }

    @Override
    public boolean delete(String login) {
        try {
            User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
            userRepository.delete(user);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }
    }
}
