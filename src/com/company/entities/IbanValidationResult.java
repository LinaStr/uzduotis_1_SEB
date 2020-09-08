package com.company.entities;

public class IbanValidationResult {
    String iban;
    boolean isValid;

    public IbanValidationResult(String iban, boolean isValid) {
        this.iban = iban;
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return iban + ';'+ isValid;
    }
}
