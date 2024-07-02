package ru.bmstu.Lab6_REST_API.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException() {
        super("Could not find a player with these parameters");
    }
}
