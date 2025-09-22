package com.senla.test.currencyConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CurrencyConverter {
    private final Map<Currency, BigDecimal> USDPerCurrency;
    private final Map<Currency, BigDecimal> CurrencyPerUSD;

    public CurrencyConverter() {
        CurrencyPerUSD = new HashMap<>();
        CurrencyPerUSD.put(Currency.USD, new BigDecimal("1.0"));
        CurrencyPerUSD.put(Currency.EUR, new BigDecimal("1.1745568"));
        CurrencyPerUSD.put(Currency.CAD, new BigDecimal("0.7356631"));
        CurrencyPerUSD.put(Currency.JPY, new BigDecimal("0.0067615"));
        CurrencyPerUSD.put(Currency.RUB, new BigDecimal("0.0119768"));

        USDPerCurrency = new HashMap<>();
        USDPerCurrency.put(Currency.USD, new BigDecimal("1.0"));
        USDPerCurrency.put(Currency.EUR, new BigDecimal("0.8513850"));
        USDPerCurrency.put(Currency.CAD, new BigDecimal("1.37805"));
        USDPerCurrency.put(Currency.JPY, new BigDecimal("147.7895499"));
        USDPerCurrency.put(Currency.RUB, new BigDecimal("83.4945474"));
    }

    public BigDecimal convert(
            BigDecimal amount, Currency fromCurrency, Currency toCurrency
    ) {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(fromCurrency);
        Objects.requireNonNull(toCurrency);

        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        BigDecimal USDPerTargetCurrency = this.USDPerCurrency.get(fromCurrency);
        BigDecimal targetCurrencyPerUSD = CurrencyPerUSD.get(toCurrency);

        return amount
                .multiply(USDPerTargetCurrency)
                .multiply(targetCurrencyPerUSD);
    }

    public Map<Currency, BigDecimal> getCurrencyPerUSD() {
        return CurrencyPerUSD;
    }
}
