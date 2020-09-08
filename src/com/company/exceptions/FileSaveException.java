package com.company.exceptions;

public class FileSaveException extends Exception {

    public FileSaveException() {
        super("Error! File was not saved");
    }
}
