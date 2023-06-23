package CurrencyExchangeTest;

import currencyexchange.Currency;
import main.CurrencyExchangeService;

import java.util.Scanner;

/**
 * Klasa testowa do przeprowadzania operacji wymiany walut przy użyciu CurrencyExchangeService.
 */
public class Test {
    /**
     * Metoda główna programu, rozpoczyna interakcję z użytkownikiem.
     *
     * @param args Argumenty wiersza poleceń (nie są używane w tym przypadku).
     */
    public static void main(String[] args) {
        /**
         * Tworzenie instancji serwisu wymiany walut.
         * Tworzenie obiektu Scanner do odczytu danych od użytkownika.
         * Wyświetlanie dostępnych walut.
         */
        CurrencyExchangeService exchangeService = new CurrencyExchangeService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Currencies:");
        for (Currency currency : Currency.values()) {
            System.out.println(currency.getName());
        }

        /**
         * Pobieranie od użytkownika preferowanej waluty do wymiany.
         * Konwertowanie wprowadzonej waluty na wartość enum Currency.
         */
        System.out.print("Enter preferred currency for exchange: ");
        String preferredCurrencyStr = scanner.nextLine().toUpperCase();
        Currency preferredCurrency = null;
        try {
            preferredCurrency = Currency.valueOf(preferredCurrencyStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid preferred currency!");
            return;
        }

        /**
         * Wyświetlanie kursów kupna i sprzedaży waluty wymiany dla preferowanej waluty.
         */
        System.out.println("Exchange rates for " + preferredCurrency.getName() + ":");
        for (Currency currency : Currency.values()) {
            if (currency != preferredCurrency) {
                double buyRate = exchangeService.convertCurrency(preferredCurrency, currency, 1);
                double sellRate = exchangeService.convertCurrency(currency, preferredCurrency, 1);

                System.out.println(currency.getName() + " - Buy rate: " + buyRate + ", Sell rate: " + sellRate);
            }
        }

        /**
         * Pobieranie od użytkownika waluty wymiany.
         * Konwertowanie wprowadzonej waluty wymiany na wartość enum Currency.
         */
        System.out.print("Enter the currency to exchange with: ");
        String targetCurrencyStr = scanner.nextLine().toUpperCase();
        Currency targetCurrency = null;
        try {
            targetCurrency = Currency.valueOf(targetCurrencyStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid target currency!");
            return;
        }

        /**
         * Pobieranie od użytkownika akcji (kupno/sprzedaż).
         * Pobieranie od użytkownika kwoty preferowanej kwoty do wymiany.
         */
        System.out.print("Enter the action (buy/sell): ");
        String action = scanner.nextLine();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        /**
         * Wymiana waluty na podstawie akcji "kupno".
         * Wymiana waluty na podstawie akcji "sprzedaż".
         * Wyświetlanie otrzymanej kwoty waluty po wymianie.
         */
        double exchangedAmount;
        if (action.equalsIgnoreCase("buy")) {
            exchangedAmount = exchangeService.convertCurrency(preferredCurrency, targetCurrency, amount);
        } else if (action.equalsIgnoreCase("sell")) {
            exchangedAmount = exchangeService.convertCurrency(targetCurrency, preferredCurrency, amount);
        } else {
            System.out.println("Invalid action!");
            return;
        }

        System.out.println("Received amount: " + exchangedAmount + " " + targetCurrency.getName());
    }
}
