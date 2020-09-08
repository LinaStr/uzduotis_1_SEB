package com.company.exceptions;

public class FileReadException extends Exception {

    public FileReadException() {
        super("Error! Could not open and read file");
    }
}
