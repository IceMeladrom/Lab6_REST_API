package ru.bmstu.Lab6_REST_API.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.Lab6_REST_API.dto.UserDto;
import ru.bmstu.Lab6_REST_API.entity.User;
import ru.bmstu.Lab6_REST_API.services.UserService;
import ru.bmstu.Lab6_REST_API.services.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PutMapping("createUserByLogin")
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @GetMapping("getUser/{login}")
    public ResponseEntity<UserDto> read(@PathVariable String login) {
        UserDto userDto = userService.read(login);
        if (userDto == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDto>> read() {
        List<UserDto> userDtos = userService.readAll();
        if (userDtos == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{login}")
    public ResponseEntity<String> delete(@PathVariable String login) {
        if (userService.delete(login))
            return new ResponseEntity<>("User " + login + " has been deleted.", HttpStatus.OK);
        return new ResponseEntity<>("User " + login + " has not been deleted.", HttpStatus.NOT_FOUND);
    }


}
