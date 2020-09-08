package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting application");

        IbanValidator ibanValidator = new IbanValidator();
        TextPrinting textPrinting = new TextPrinting();
        InputReader inputReader = new InputReader();
        IbanValidationApp ibanValidationApp = new IbanValidationApp(ibanValidator, textPrinting, inputReader);

        System.out.println("System is ready");


        ibanValidationApp.start();
    }
}
