package com.company;

public class IbanValidator {
    
    private static int calculateMod(String iban) {
        iban = iban.replaceAll("\\s+", "");
        iban = iban.toUpperCase();
        String reformattedIban = iban.substring(4) + iban.substring(0, 4);
        long total = 0L;

        for(int i = 0; i < reformattedIban.length(); ++i) {
            int numericValue = Character.getNumericValue(reformattedIban.charAt(i));
            if (numericValue < 0 || numericValue > 35) {
                throw new IllegalArgumentException("Invalid Character[" + i + "] = '" + numericValue + "'");
            }

            total = (numericValue > 9 ? total * 100L : total * 10L) + (long)numericValue;
            if (total > 999999999L) {
                total %= 97L;
            }
        }
        return (int)(total % 97L);
    }

    public boolean validateIban(String iban){
        return (calculateMod(iban) == 1);
    }

}
