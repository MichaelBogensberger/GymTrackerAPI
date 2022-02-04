package com.gymtracker.gymtracker.exeption;

public class ValidationDeclinedException extends Exception{
    public ValidationDeclinedException() {
        super("Tried to access forbidden Data you asshole");
    }
}
