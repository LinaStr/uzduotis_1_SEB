package com.company;

public class TextPrinting {

    public void mainMenu() {
        System.out.println();
        System.out.println("Main menu:\n" +
                "[1] Validate single IBAN\n" +
                "[2] Validate IBAN from .txt file\n" +
                "[3] Exit");
    }

    public void exitMessage(){
        System.out.println("Thank you for visiting best IBAN validation app! Hire this app creator asap!");
    }

    public void askForIban(){
        System.out.println("Please enter IBAN number you want to validate");
    }

    public void validatedIbanMessage(String iban, Boolean valid){
        if (valid){
            System.out.println("IBAN "+ iban + " is valid");
        }else{
            System.out.println("IBAN "+ iban + " is NOT valid");
        }
        System.out.println();
    }

    public void askForFilePath() {
        System.out.println("Please enter full file path to .txt file with IBAN numbers");
    }


}
