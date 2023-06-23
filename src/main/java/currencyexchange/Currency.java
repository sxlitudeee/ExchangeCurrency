package currencyexchange;
/**
 * Reprezentuje walutę.
 */
public enum Currency {
    USD("USD (US Dollar)"),
    EUR("EUR (Euro)"),
    PLN("PLN (Polish Zloty)"),
    CZK("CZK (Czech Krona)"),
    GBP("GBP (British Pound)");

    private String name;
    /**
     * Tworzy nową instancję waluty z podaną nazwą.
     *
     * @param name Nazwa waluty.
     */
    Currency(String name) {
        this.name = name;
    }
    /**
     * Zwraca nazwę waluty.
     *
     * @return Nazwa waluty.
     */
    public String getName() {
        return name;
    }
}