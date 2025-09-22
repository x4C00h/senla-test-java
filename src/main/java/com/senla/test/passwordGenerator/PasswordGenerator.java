package com.senla.test.passwordGenerator;

import java.util.concurrent.ThreadLocalRandom;

public final class PasswordGenerator {
    public static String generate(int passwordLength) {
        if (passwordLength == 0) {
            throw new IllegalArgumentException(
                    "ERROR: Password length must be greater than zero"
            );
        }

        StringBuilder password = new StringBuilder();
        final ThreadLocalRandom random = ThreadLocalRandom.current();

        final String allowedChars = CharacterSet.ALLOWED_CHARS.getChars();
        for (int i = 0; i < passwordLength; ++i) {
            password.append(
                    allowedChars.charAt(
                            random.nextInt(allowedChars.length())
                    )
            );
        }

        return password.toString();
    }
}
