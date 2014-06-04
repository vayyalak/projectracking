package com.gridpoint.energy.domainmodel.monetization;

import com.gridpoint.energy.util.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;

/**
 * Represents an amount of money in a particular currency.
 */
public class MonetaryAmount implements Serializable, Comparable<MonetaryAmount> {
    private static final long serialVersionUID = 1L;
    
    /**
     * the amount of currency.  Default value is 0.0.
     */
    private double amount;

    // These aren't used anywhere, but are provided so that the JSON implementation
    // realizes that they are properties to be serialized.  In practice these properties are derived from the currency.
    private String currencyCode;
    private String symbol;
    private int defaultFractionDigits;

    /**
     * the locale for which this monetary amount is displayed
     */
    // transient to avoid serialization
    private transient Locale displayLocale = Locale.getDefault();

    /**
     * the currency for which the {@link #amount} is expressed
     */
    // transient to avoid serialization
    private transient Currency currency = Currency.getInstance(Locale.getDefault());

    /**
     * Creates and initializes a new monetary amount instance of magnitude 0.0 in the currency of the default locale for display in the current locale.
     */
    // Required for Jackson JSON
    public MonetaryAmount() {
    }

    /**
     * Creates and initializes a new monetary amount instance in the currency of the default locale for display in the current locale.
     *
     * @param amount the amount of currency
     */
    public MonetaryAmount(double amount) {
        setAmount(amount);
    }

    /**
     * Creates and initializes a new monetary amount instance for display in the default locale.
     *
     * @param amount       the amount of currency
     * @param currencyCode the ISO 4217 code of the currency in which the {@link #amount} is expressed
     * @throws NullPointerException     - if {@code locale} is null or {@code currencyCode} is null
     * @throws IllegalArgumentException - if {@code currencyCode} is not a supported ISO 4217 code.
     */
    public MonetaryAmount(double amount, String currencyCode) {
        this(amount);
        setCurrencyCode(currencyCode);
    }

    /**
     * Creates and initializes a new monetary amount instance of 0.0 in the default currency of the given locale.
     *
     * @param amount       the amount of currency
     * @param currencyCode the ISO 4217 code of the currency in which the {@link #amount} is expressed
     * @param locale       the locale in which the monetary amount will be displayed
     * @throws NullPointerException     - if {@code locale} is null or {@code currencyCode} is null
     * @throws IllegalArgumentException - if {@code currencyCode} is not a supported ISO 4217 code.
     */
    public MonetaryAmount(double amount, String currencyCode, Locale locale) {
        this(amount, currencyCode);
        setDisplayLocale(locale);
    }

    /**
     * Gets the amount of currency.
     * @return the amount of currency
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of currency.
     * @param amount the amount of currency
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the ISO 4217 currency code.
     * @return the ISO 4217 currency code
     * @see Currency#getCurrencyCode()
     */
    public String getCurrencyCode() {
        return currency.getCurrencyCode();
    }

    /**
     * Sets the ISO 4217 currency code.
     * @param currencyCode the ISO 4217 currency code
     * @throws NullPointerException - if {@code currencyCode} is null
     * @throws IllegalArgumentException - if {@code currencyCode} is not a supported ISO 4217 code.
     */
    public void setCurrencyCode(String currencyCode) {

        // Validate the argument.  This currency method throws exceptions if there's a problem.
        setCurrency(Currency.getInstance(currencyCode));
    }

    /**
     * Gets the symbol of this currency for display in the {@link #displayLocale}
     * @return the symbol of this currency for display in the {@link #displayLocale}
     * @see Currency#getSymbol()
     */
    public String getSymbol() {
        return currency.getSymbol(displayLocale);
    }

    public void setSymbol(String symbol) {
        // This method is provided so that JSON recognizes the property.
        // Ignore attempts to set this property directly, as this is derived from the currency.
    }

    /**
     * Gets the default number of fraction digits used with this currency.
     * @return the default number of fraction digits used with this currency
     * @see Currency#getDefaultFractionDigits()
     */
    public int getDefaultFractionDigits() {
        return currency.getDefaultFractionDigits();
    }

    public void setDefaultFractionDigits(int defaultFractionDigits) {
        // This method is provided so that JSON recognizes the property.
        // Ignore attempts to set this property directly, as this is derived from the currency.
    }

    /**
     * Gets the locale for which this monetary amount is displayed
     * @return the locale for which this monetary amount is displayed
     */
    @JsonIgnore
    public Locale getDisplayLocale() {
        return displayLocale;
    }

    /**
     * Sets the locale for which the monetary amount will be displayed
     * @param displayLocale the locale for which the monetary amount will be displayed
     * @throws NullPointerException - if {@code locale} is null
     */
    @JsonIgnore
    public void setDisplayLocale(Locale displayLocale) {
        NotNull.verify(displayLocale, "displayLocale");
        this.displayLocale = displayLocale;

        // When setting the display locale, set the fields derived from the display locale.
        // These aren't used in this class but may be used by various serializers and marshallers.
        symbol = getSymbol();
    }

    /**
     * Gets the currency for which the {@link #amount} is expressed.
     * @return the currency for which the {@link #amount} is expressed
     */
    @JsonIgnore
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets the currency for which the {@link #amount} is expressed.
     * @param currency the currency for which the {@link #amount} is expressed
     * @throws NullPointerException - if {@code currencyCode} is null
     * @throws IllegalArgumentException - if {@code currencyCode} is not a supported ISO 4217 code.
     */
    @JsonIgnore
    public void setCurrency(Currency currency) {
        NotNull.verify(currency, "currency");
        this.currency = currency;

        // When setting the currency, set the fields derived from the currency.
        // These aren't used in this class but may be used by various serializers and marshallers.
        symbol = getSymbol();
        defaultFractionDigits = getDefaultFractionDigits();
        currencyCode = getCurrencyCode();
    }

    @Override
    public String toString() {
        return "MonetaryAmount{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", displayLocale=" + displayLocale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonetaryAmount)) return false;

        MonetaryAmount that = (MonetaryAmount) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!currency.equals(that.currency)) return false;
        if (!displayLocale.equals(that.displayLocale)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayLocale.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    /**
     * Compares this instance to another
     * @param that the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if {@code that} is null
     * @see Comparable
     */
    @Override
    public int compareTo(MonetaryAmount that) {
        if (this.amount == that.amount) {
            return this.currencyCode.compareTo(that.currencyCode);
        } else {
            return this.amount > that.amount ? 1 : -1;
        }
    }
}
