package com.senla.test.hangman;

import java.util.Arrays;
import java.util.Objects;

public final class GameState {
    private final String targetWord;
    private final Character[] guessedLetters;
    private Integer attemptsRemaining;
    private Integer numberOfGuessedLetter;

    public GameState(String targetWord) throws IllegalArgumentException {
        Objects.requireNonNull(targetWord);
        if (targetWord.isBlank()) {
            throw new IllegalArgumentException(
                    "ERROR: Target word cannot be an empty or blank string"
            );
        }

        this.targetWord = targetWord;
        this.attemptsRemaining = 7;
        this.numberOfGuessedLetter = 0;
        this.guessedLetters = new Character[targetWord.length()];
        Arrays.fill(guessedLetters, '_');
    }

    public void processGuess(Character userInput) {
        Objects.requireNonNull(userInput);

        boolean isLetterActuallyGuessed = Arrays.asList(guessedLetters).contains(userInput);
        if (isLetterActuallyGuessed) {
            System.out.println(
                    "Letter " + Character.toUpperCase(userInput) + " is already guessed"
            );
            return;
        }

        boolean isUserGuessed = targetWord.contains(userInput.toString());
        if (!isUserGuessed) {
            attemptsRemaining -= 1;
            return;
        }

        for (int i = 0; i < targetWord.length(); ++i) {
            if (!userInput.equals(targetWord.charAt(i))) {
                continue;
            }
            guessedLetters[i] = targetWord.charAt(i);
            numberOfGuessedLetter += 1;
        }
    }

    public boolean isGameOver() {
        return attemptsRemaining.equals(0) || numberOfGuessedLetter.equals(targetWord.length());
    }

    public boolean isUserWin() {
        return !attemptsRemaining.equals(0) && numberOfGuessedLetter.equals(targetWord.length());
    }

    public String getTargetWord() {
        return targetWord;
    }

    public Character[] getGuessedLetters() {
        return guessedLetters;
    }

    public Integer getAttemptsRemaining() {
        return attemptsRemaining;
    }
}
