package com.company;

import com.company.exceptions.InvalidChoiceException;

import java.util.Scanner;

public class InputReader {
    public int mainMenuChoices = 3;
    private static Scanner sc = new Scanner(System.in);

    public int validateChoice(int numberOfChoices) throws InvalidChoiceException {
        String choiceString = sc.nextLine();
        try {
            int choice = Integer.parseInt(choiceString);
            if (choice <= numberOfChoices && choice > 0) {
                return choice;
            } else {
                throw new InvalidChoiceException();
            }
        } catch (Exception e) {
            throw new InvalidChoiceException();
        }
    }

    public String stringInput(){
        return sc.nextLine();
    }
}
