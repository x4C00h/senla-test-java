package com.senla.test.passwordGenerator;

public final class PasswordGeneratorApp {
    final UserInputHandler userInputHandler = new UserInputHandler();

    public static void main(String[] args) {
        System.out.println("Password Generator");
        new PasswordGeneratorApp().run();
    }

    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            int passwordLength = userInputHandler.askPasswordLength();

            String password = PasswordGenerator.generate(passwordLength);
            System.out.println(
                    "\n==============================\n" +
                    "Your password is " + password +
                    "\n=============================="
            );

            keepRunning = userInputHandler.askKeepRunning();
        }
    }
}
