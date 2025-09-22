package com.senla.test.currencyConverter;

import java.math.BigDecimal;

public final class CurrencyConverterApp {
    private final CurrencyConverter currencyConverter = new CurrencyConverter();
    private final UserInputHandler userInputHandler = new UserInputHandler();

    public static void main(String[] args) {
        new CurrencyConverterApp().run();
    }

    public void run() {
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                ConsolePrinter.displayCurrencies();
                Currency currencyForConversion = userInputHandler.askCurrency();

                ConsolePrinter.displayExchangeRates(currencyConverter);
                Currency currencyToConvertInto = userInputHandler.askCurrency();

                BigDecimal amount = userInputHandler.askAmount();

                BigDecimal newAmount = currencyConverter.convert(
                        amount, currencyForConversion, currencyToConvertInto
                );
                ConsolePrinter.displayConvertResult(
                        amount, currencyForConversion, newAmount, currencyToConvertInto
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            keepRunning = userInputHandler.askKeepRunning();
        }
    }
}
