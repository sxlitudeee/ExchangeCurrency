package currencyexchange;
/**
 * Reprezentuje kurs wymiany walut pomiędzy dwiema walutami.
 */
public class ExchangeRate {
    private Currency baseCurrency;
    private Currency targetCurrency;
    private double buyRate;
    private double sellRate;
    /**
     * Tworzy instancję kursu wymiany walut.
     *
     * @param baseCurrency   Waluta bazowa.
     * @param targetCurrency Docelowa waluta.
     * @param buyRate        Kurs kupna.
     * @param sellRate       Kurs sprzedaży.
     */
    public ExchangeRate(Currency baseCurrency, Currency targetCurrency, double buyRate, double sellRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    /**
     * Zwraca walutę bazową.
     *
     * @return Waluta bazowa.
     */
    public Currency getBaseCurrency() {
        return baseCurrency;
    }
    /**
     * Zwraca docelową walutę.
     *
     * @return Docelowa waluta.
     */
    public Currency getTargetCurrency() {
        return targetCurrency;
    }
    /**
     * Zwraca kurs kupna.
     *
     * @return Kurs kupna.
     */
    public double getBuyRate() {
        return buyRate;
    }
    /**
     * Zwraca kurs sprzedaży.
     *
     * @return Kurs sprzedaży.
     */
    public double getSellRate() {
        return sellRate;
    }
}
