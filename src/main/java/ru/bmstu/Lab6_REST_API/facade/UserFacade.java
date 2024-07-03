package ru.bmstu.Lab6_REST_API.facade;

import ru.bmstu.Lab6_REST_API.dto.UserDto;
import ru.bmstu.Lab6_REST_API.entity.User;

public class UserFacade {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getEmail());
        user.setId(userDto.getId());
        return user;
    }

}
