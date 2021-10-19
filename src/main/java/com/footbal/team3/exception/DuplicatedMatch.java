package com.footbal.team3.exception;

public class DuplicatedMatch extends RuntimeException{


    public DuplicatedMatch() {
        super("Duplicated Match");     }

    public DuplicatedMatch(String message) {
        super(message);
    }


}




