package com.company;

import com.company.entities.IbanValidationResult;
import com.company.exceptions.FileReadException;
import com.company.exceptions.FileSaveException;
import com.company.exceptions.InvalidChoiceException;

import java.util.ArrayList;
import java.util.List;

public class IbanValidationApp {
    private final IbanValidator ibanValidator;
    private final TextPrinting textPrinting;
    private final InputReader inputReader;

    public IbanValidationApp(IbanValidator ibanValidator, TextPrinting textPrinting, InputReader inputReader) {
        this.ibanValidator = ibanValidator;
        this.textPrinting = textPrinting;
        this.inputReader = inputReader;
    }

    public void start() {
        int userChoice;
        do {
            textPrinting.mainMenu();
            userChoice = getUserChoice();
            mainAppLogic(textPrinting, userChoice);
        } while (userChoice != 3);
        textPrinting.exitMessage();
    }


    private void mainAppLogic(TextPrinting textPrinting, int userChoice) {
        switch (userChoice) {
            case 1:
                textPrinting.askForIban();
                String usersIban = inputReader.stringInput();
                textPrinting.validatedIbanMessage(usersIban, ibanValidator.validateIban(usersIban));
                break;
            case 2:
                textPrinting.askForFilePath();
                String usersFilePath = inputReader.stringInput();
                FileOperator fileOperator = new FileOperator(usersFilePath);
                List<String> ibansFromFile = getIbansFromFile(fileOperator);
                List<IbanValidationResult> allIbansValidated = new ArrayList<>();
                for (String iban : ibansFromFile) {
                    allIbansValidated.add(new IbanValidationResult(iban, ibanValidator.validateIban(iban)));
                }
                writeIbansToFile(fileOperator, allIbansValidated);
                break;
        }

    }

    private void writeIbansToFile(FileOperator fileOperator, List<IbanValidationResult> allIbansValidated) {
        try {
            fileOperator.writeValidatedIbansToFile(allIbansValidated);
        } catch (FileSaveException e) {
            System.err.println(e.getMessage());
        }
    }

    private List<String> getIbansFromFile(FileOperator fileOperator) {
        List<String> ibansFromFile = new ArrayList<>();
        try {
            ibansFromFile = fileOperator.getAllIbanFomFile();
        } catch (FileReadException e) {
            System.err.println(e.getMessage());
        }
        return ibansFromFile;
    }

    private int getUserChoice()  {
        try {
            return inputReader.validateChoice(inputReader.mainMenuChoices);
        } catch (InvalidChoiceException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
