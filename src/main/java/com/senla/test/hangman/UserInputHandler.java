package com.senla.test.hangman;

import java.util.Scanner;

public final class UserInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public Character askLetter() {
        do {
            System.out.print("Enter your letter: ");
            String letter = scanner.nextLine();
            if (isValidLetter(letter)) {
                return letter.toLowerCase().charAt(0);
            }

            System.out.println("Invalid input! Please try again.\n");
        } while (true);
    }

    private boolean isValidLetter(String userInput) {
        return userInput.matches("^[a-zA-Z]$");
    }

    public boolean askNewGame() {
        do {
            System.out.print("Do u want to play again? (y/n): ");
            String answer = scanner.nextLine();
            if (isValidYesOrNo(answer)) {
                return isYes(answer);
            }

            System.out.println(
                    "Invalid input! Please try again. Type 'y' to play again or 'n' to quit.\n"
            );
        } while (true);
    }

    private boolean isValidYesOrNo(String answer) {
        return answer.matches("^(?i)(y|n|yes|no)$");
    }

    private boolean isYes(String answer) {
        return answer.matches("^(?i)(y|yes)$");
    }
}
