package com.senla.test.hangman;

import java.util.Objects;

public final class ConsolePrinter {
    public static void displayInitialMessage() {
        System.out.println("""
                
                88        88         db         888b      88    ,ad8888ba,   88b           d88         db         888b      88 \s
                88        88        d88b        8888b     88   d8""    `"8b  888b         d888        d88b        8888b     88 \s
                88        88       d8"`8b       88 `8b    88  d8"            88`8b       d8"88       d8"`8b       88 `8b    88 \s
                88aaaaaaaa88      d8"  `8b      88  `8b   88  88             88 `8b     d8" 88      d8"  `8b      88  `8b   88 \s
                88""\"""\"""88     d8YaaaaY8b     88   `8b  88  88      88888  88  `8b   d8"  88     d8YaaaaY8b     88   `8b  88 \s
                88        88    d8""\"""\"""8b    88    `8b 88  Y8,        88  88   `8b d8"   88    d8""\"""\"""8b    88    `8b 88 \s
                88        88   d8"        `8b   88     `8888   Y8a.    .a88  88    `888"    88   d8"        `8b   88     `8888 \s
                88        88  d8"          `8b  88      `888    `"Y88888P"   88     `8"     88  d8"          `8b  88      `888 \s""");
    }

    public static void displayGameState(GameState state) {
        Objects.requireNonNull(state);

        StringBuilder builder = new StringBuilder();

        builder.append("\n");
        builder.append(
                getArtOfHangman(state.getAttemptsRemaining())
        );
        builder.append("\nAttempts remaining: ");
        builder.append("❤ ".repeat(state.getAttemptsRemaining()));
        builder.append(" (");
        builder.append(state.getAttemptsRemaining());
        builder.append(")");
        builder.append("\n");

        builder.append("Your word: ");
        for (Character c : state.getGuessedLetters()) {
            builder.append(c);
            builder.append(" ");
        }

        System.out.println(builder);
    }

    private static String getArtOfHangman(int remaining) {
        final String[] hangmanProgressASCIArt = new String[]{"""
              +---+
              |   |
              O   |
             /|\\  |
             / \\  |
                  |
            =========""", """
              +---+
              |   |
              O   |
             /|\\  |
             /    |
                  |
            ========""", """
              +---+
              |   |
              O   |
             /|\\  |
                  |
                  |
            =========""", """
              +---+
              |   |
              O   |
             /|   |
                  |
                  |
            =========""", """
              +---+
              |   |
              O   |
              |   |
                  |
                  |
            =========""", """
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========""", """
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========""",
        };
        return hangmanProgressASCIArt[remaining - 1];
    }

    public static void displayResults(GameState state) {
        Objects.requireNonNull(state);

        if (state.isUserWin()) {
            displayCongratulation(state.getTargetWord());
        } else {
            displayNiceTry(state.getTargetWord());
        }
    }

    private static void displayNiceTry(String targetWord) {
        Objects.requireNonNull(targetWord);

        System.out.println(
                "\n" + "Nice try! You've run out of attempts\n" +
                        "Hidden world was " + targetWord + "\n"
        );
    }

    private static void displayCongratulation(String targetWord) {
        Objects.requireNonNull(targetWord);

        System.out.println(
                "\n" + "Congratulation!\n" + "Congratulation!\n" + "Congratulation!\n" +
                        "Hidden world was " + targetWord + "\n"
        );
    }
}
