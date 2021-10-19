package com.footbal.team3.exception;

public class DuplicatedPlayer extends RuntimeException {

    public DuplicatedPlayer() {
        super("Duplicated Player");     }

    public DuplicatedPlayer(String message) {
        super(message);
    }
}
