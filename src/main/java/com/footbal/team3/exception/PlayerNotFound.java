package com.footbal.team3.exception;

public class PlayerNotFound extends RuntimeException {

    public PlayerNotFound() {
        super("Player not found");     }

    public PlayerNotFound(String message) {
        super(message);
    }
}

