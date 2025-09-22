package com.senla.test.hangman;

import java.util.concurrent.ThreadLocalRandom;

public final class WordRepository {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final String[] words = new String[]{
            "cat",
            "dog",
            "phone",
            "butterfly"
    };

    public String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
