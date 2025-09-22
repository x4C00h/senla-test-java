package com.senla.test.currencyConverter;

public enum Currency {
    USD("US Dollar"),
    EUR("Euro"),
    CAD("Canadian Dollar"),
    JPY("Japan Yen"),
    RUB("Ruble");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
