package com.senla.test.passwordGenerator;

public enum CharacterSet {
    UPPER_CASE("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    LOWER_CASE("abcdefghijklmnopqrstuvwxyz"),
    DIGITS("0123456789"),
    SPECIAL("!@#$%^&*()_+-=[]{}|;:,.<>?"),
    ALLOWED_CHARS(UPPER_CASE.chars + LOWER_CASE.chars + DIGITS.chars + SPECIAL.chars);

    private final String chars;

    CharacterSet(String chars) {
        this.chars = chars;
    }

    public String getChars() {
        return chars;
    }
}