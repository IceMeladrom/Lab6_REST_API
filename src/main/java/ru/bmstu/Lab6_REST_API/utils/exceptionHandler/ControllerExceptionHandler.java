package ru.bmstu.Lab6_REST_API.utils.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bmstu.Lab6_REST_API.exceptions.PlayerNotFoundException;
import ru.bmstu.Lab6_REST_API.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String playerNotFoundHandler(PlayerNotFoundException ex) {
        return ex.getMessage();
    }
}
