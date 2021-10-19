package com.footbal.team3.exception;

public class MatchNotFound extends RuntimeException{

    public MatchNotFound() {
        super("match not found");     }

    public MatchNotFound(String message) {
        super(message);
    }
}








