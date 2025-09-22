package com.senla.test.currencyConverter;

import java.math.BigDecimal;
import java.util.Scanner;

public final class UserInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public Currency askCurrency() {
        do {
            System.out.print("Enter currency number: ");
            String input = scanner.nextLine();
            if (!isValidCurrencyNumber(input)) {
                System.out.println(
                        "ERROR: Invalid input. User numeric symbol between 1 and 5\n"
                );
                continue;
            }
            return Currency.values()[Integer.parseInt(input) - 1];
        } while (true);
    }

    private boolean isValidCurrencyNumber(String input) {
        int currencyLength = Currency.values().length;
        try {
            int inputAsInteger = Integer.parseInt(input);
            return inputAsInteger > 0 && inputAsInteger <= currencyLength;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public BigDecimal askAmount() {
        do {
            System.out.print("\nEnter amount to convert: ");
            String input = scanner.nextLine();

            try {
                BigDecimal amount = new BigDecimal(input);
                if (amount.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("ERROR: Amount cannot be zero!");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Use only numeric values!");
            }
        } while (true);
    }

    public boolean askKeepRunning() {
        do {
            System.out.print("\nDo you want to continue? (y/n): ");
            String input = scanner.nextLine();
            if (isValidAnswerYesOrNo(input)) {
                return isYes(input);
            }
            System.out.println(
                    "ERROR: Invalid input! Please try again. Type 'y' to play again or 'n' to quit."
            );
        } while (true);
    }

    private boolean isValidAnswerYesOrNo(String answer) {
        return answer.matches("^(?i)(y|n|yes|no)$");
    }

    private boolean isYes(String answer) {
        return answer.matches("^(?i)(y|yes)$");
    }
}
