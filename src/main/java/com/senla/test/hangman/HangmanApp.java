package com.senla.test.hangman;

public final class HangmanApp {
    private final WordRepository wordRepository;
    private final UserInputHandler userInputHandler;
    private GameState state;

    public static void main(String[] args) {
        new HangmanApp().run();
    }

    public HangmanApp() {
        ConsolePrinter.displayInitialMessage();
        wordRepository = new WordRepository();
        userInputHandler = new UserInputHandler();
    }

    public void run() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            try {
                startNewGame();
                ConsolePrinter.displayResults(state);
            } catch (Exception e) {
                e.printStackTrace();
            }

            keepPlaying = userInputHandler.askNewGame();
        }
    }

    private void startNewGame() {
        state = new GameState(wordRepository.getRandomWord());

        Character userInput;
        do {
            ConsolePrinter.displayGameState(state);
            userInput = userInputHandler.askLetter();
            state.processGuess(userInput);
        } while (!state.isGameOver());
    }
}
