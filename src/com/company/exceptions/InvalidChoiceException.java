package com.company.exceptions;

public class InvalidChoiceException extends Exception {

    public InvalidChoiceException() {
        super("Please enter a valid number");
    }
}
