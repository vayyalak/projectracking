package com.gridpoint.energy.util.text;

/**
 * A "hidden" string. Its {@link Object#toString} method will always return "***" and it's equals will only
 * return true when comparing to itself.
 *
 * This is useful for obscuring passwords.
 */
public class HiddenString
{
    public static final String OBFUSCATION_STRING = "***";

    public HiddenString()
    {
    }

    public HiddenString(final String designatedString)
    {
        string = designatedString;
    }

    private String string;

    String getString()
    {
        return string;
    }

    void setString(final String designatedString)
    {
        string = designatedString;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this==o)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        return OBFUSCATION_STRING;
    }
}
