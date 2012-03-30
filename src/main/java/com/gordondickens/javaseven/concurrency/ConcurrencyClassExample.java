package com.gordondickens.javaseven.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class ConcurrencyClassExample {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyClassExample.class);

    public static void main(String[] args) {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        for (Currency currency : currencies) {
            logger.debug("" + currency.getDisplayName()
                    + " - " + currency.getDisplayName(Locale.GERMAN)
                    + " - " + currency.getNumericCode());
        }

    }
}
