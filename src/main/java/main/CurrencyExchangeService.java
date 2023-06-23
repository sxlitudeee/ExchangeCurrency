package main;

import currencyexchange.Currency;
import currencyexchange.ExchangeRate;
import java.util.HashMap;
import java.util.Map;
/**
 * Klasa pakietu main obsługująca wymianę walut.
 */
public class CurrencyExchangeService {
    private Map<Currency, Map<Currency, ExchangeRate>> exchangeRates;
    /**
     * Tworzy instancję serwisu wymiany walut.
     * Inicjalizuje tablicę kursów wymiany walut.
     */
    public CurrencyExchangeService() {
        exchangeRates = new HashMap<>();
        /**
         *  Inicjalizacja kursów wymiany walut
         */
        Map<Currency, ExchangeRate> usdRates = new HashMap<>();
        usdRates.put(Currency.EUR, new ExchangeRate(Currency.USD, Currency.EUR, 0.8987, 1.1128));
        usdRates.put(Currency.PLN, new ExchangeRate(Currency.USD, Currency.PLN, 4.0219, 0.2486));
        usdRates.put(Currency.CZK, new ExchangeRate(Currency.USD, Currency.CZK, 21.6471, 0.0462));
        usdRates.put(Currency.GBP, new ExchangeRate(Currency.USD, Currency.GBP, 0.7747, 1.2908));
        exchangeRates.put(Currency.USD, usdRates);

        Map<Currency, ExchangeRate> eurRates = new HashMap<>();
        eurRates.put(Currency.USD, new ExchangeRate(Currency.EUR, Currency.USD, 1.0824, 0.9238));
        eurRates.put(Currency.PLN, new ExchangeRate(Currency.EUR, Currency.PLN, 4.4126, 0.2266));
        eurRates.put(Currency.CZK, new ExchangeRate(Currency.EUR, Currency.CZK, 23.75, 0.0421));
        eurRates.put(Currency.GBP, new ExchangeRate(Currency.EUR, Currency.GBP, 0.85, 1.1765));
        exchangeRates.put(Currency.EUR, eurRates);

        Map<Currency, ExchangeRate> plnRates = new HashMap<>();
        plnRates.put(Currency.USD, new ExchangeRate(Currency.PLN, Currency.USD, 0.2373, 4.2147));
        plnRates.put(Currency.EUR, new ExchangeRate(Currency.PLN, Currency.EUR, 0.2161, 4.6271));
        plnRates.put(Currency.CZK, new ExchangeRate(Currency.PLN, Currency.CZK, 5.2059, 0.1921));
        plnRates.put(Currency.GBP, new ExchangeRate(Currency.PLN, Currency.GBP, 0.1863, 5.3672));
        exchangeRates.put(Currency.PLN, plnRates);

        Map<Currency, ExchangeRate> czkRates = new HashMap<>();
        czkRates.put(Currency.USD, new ExchangeRate(Currency.CZK, Currency.USD, 0.0402, 24.8667));
        czkRates.put(Currency.EUR, new ExchangeRate(Currency.CZK, Currency.EUR, 0.0366, 27.3));
        czkRates.put(Currency.PLN, new ExchangeRate(Currency.CZK, Currency.PLN, 0.1639, 6.1));
        czkRates.put(Currency.GBP, new ExchangeRate(Currency.CZK, Currency.GBP, 0.0316, 31.6667));
        exchangeRates.put(Currency.CZK, czkRates);

        Map<Currency, ExchangeRate> gbpRates = new HashMap<>();
        gbpRates.put(Currency.USD, new ExchangeRate(Currency.GBP, Currency.USD, 1.2332, 0.8109));
        gbpRates.put(Currency.EUR, new ExchangeRate(Currency.GBP, Currency.EUR, 1.1233, 0.8902));
        gbpRates.put(Currency.PLN, new ExchangeRate(Currency.GBP, Currency.PLN, 5.0273, 0.1989));
        gbpRates.put(Currency.CZK, new ExchangeRate(Currency.GBP, Currency.CZK, 27.0588, 0.037));
        exchangeRates.put(Currency.GBP, gbpRates);
    }
    /**
     * Konwertuje podaną ilość waluty z jednej waluty bazowej na docelową walutę.
     *
     * @param baseCurrency   Waluta bazowa.
     * @param targetCurrency Docelowa waluta.
     * @param amount         Ilość waluty do skonwertowania.
     * @return Skonwertowana wartość waluty.
     * @throws IllegalArgumentException Jeśli nie znaleziono kursu wymiany dla podanych walut.
     */
    public double convertCurrency(Currency baseCurrency, Currency targetCurrency, double amount) {
        Map<Currency, ExchangeRate> rates = exchangeRates.get(baseCurrency);
        ExchangeRate exchangeRate = rates.get(targetCurrency);

        if (exchangeRate != null) {
            if (amount > 0) {
                return amount * exchangeRate.getBuyRate();
            } else {
                return amount * exchangeRate.getSellRate();
            }
        } else {
            throw new IllegalArgumentException("Exchange rate not found for the given currencies.");
        }
    }
}
