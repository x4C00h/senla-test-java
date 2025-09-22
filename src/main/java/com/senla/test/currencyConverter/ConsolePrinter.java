package com.senla.test.currencyConverter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class ConsolePrinter {
    public static void displayCurrencies() {
        System.out.println("Select currency for conversion:");
        Currency[] values = Currency.values();

        StringBuilder menuList = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            menuList.append(i + 1);
            menuList.append(") ");
            menuList.append(values[i].getName());
            menuList.append("\n");
        }
        System.out.print(menuList);
    }

    public static void displayExchangeRates(CurrencyConverter currencyConverter) {
        Objects.requireNonNull(currencyConverter);

        Currency[] values = Currency.values();
        Map<Currency, BigDecimal> exchangeRateToUSD =
                currencyConverter.getCurrencyPerUSD();
        StringBuilder menuList = new StringBuilder();

        System.out.println("\nSelect currency for conversion:");
        for (int i = 0; i < values.length; ++i) {
            menuList.append(i + 1);
            menuList.append(") ");
            menuList.append(values[i].name());
            menuList.append(" - ");
            menuList.append(exchangeRateToUSD.get(values[i]));
            menuList.append("$\n");
        }

        System.out.print(menuList);
    }

    public static void displayConvertResult(
            BigDecimal oldAmount, Currency oldCurrency,
            BigDecimal newAmount, Currency newCurrency
    ) {
        Objects.requireNonNull(oldAmount);
        Objects.requireNonNull(newAmount);
        Objects.requireNonNull(oldCurrency);
        Objects.requireNonNull(newCurrency);

        System.out.println(
                "\n=================================================\n" +
                oldAmount + " " + oldCurrency.name() + " was converted to " +
                newAmount + " " + newCurrency.name() +
                "\n================================================="
        );
    }
}
