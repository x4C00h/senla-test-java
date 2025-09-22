package com.senla.test.passwordGenerator;

import java.util.Scanner;

public final class UserInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int askPasswordLength() {
        do {
            System.out.print(
                    "\nEnter required password length between 8 and 12: "
            );
            String input = scanner.nextLine();
            if (!isValidInteger(input)) {
                System.out.println("ERROR: Use only numeric values!");
                continue;
            }

            int length = Integer.parseInt(input);
            if (!isValidPasswordLength(length))
            {
                System.out.println(
                        "ERROR: Invalid password length! " +
                        "Use only values between 8 and 12."
                );
                continue;
            }

            return length;
        } while (true);
    }

    private boolean isValidInteger(String intString) {
        return intString.matches("-?(0|[1-9]\\d*)");
    }

    private boolean isValidPasswordLength(int length) {
        return length >= 8 && length <= 12;
    }

    public boolean askKeepRunning() {
        do {
            System.out.print("\nDo you want to continue? (y/n): ");
            String input = scanner.nextLine();
            if (isValidAnswerYesOrNo(input)) {
                return isYes(input);
            }
            System.out.println(
                    "ERROR: Invalid input! Please try again. " +
                    "Type 'y' to play again or 'n' to quit."
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
