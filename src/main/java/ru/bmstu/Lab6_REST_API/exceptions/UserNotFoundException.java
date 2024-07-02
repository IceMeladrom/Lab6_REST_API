package ru.bmstu.Lab6_REST_API.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Could not find a user with these parameters");
    }
}
