package com.company;

import com.company.entities.IbanValidationResult;
import com.company.exceptions.FileReadException;
import com.company.exceptions.FileSaveException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {
    private String filePath;

    public FileOperator(String filePath) {
        this.filePath = filePath;
    }

    public void writeValidatedIbansToFile(List<IbanValidationResult> validatedIbans) throws FileSaveException {
        filePath = filePath.replace(".txt", ".out");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (IbanValidationResult validatedIban : validatedIbans) {
                bw.write(validatedIban.toString() + "\n");
            }
        } catch (IOException e) {
            throw new FileSaveException();
        }
    }

    public List<String> getAllIbanFomFile() throws FileReadException {
        List<String> ibansFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                ibansFromFile.add(strCurrentLine);
            }
            return ibansFromFile;
        } catch (IOException e) {
            throw new FileReadException();
        }
    }
}

