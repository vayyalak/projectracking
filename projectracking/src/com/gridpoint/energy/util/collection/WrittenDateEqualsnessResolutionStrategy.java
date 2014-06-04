package com.gridpoint.energy.util.collection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Formats all dates and uses the written strings for comparison. This allows us to ignore implementation-specific
 * differences like {@link java.util.Date} vs. {@link java.sql.Timestamp}.
 *
 * Uses {@link org.apache.commons.lang.builder.EqualsBuilder} for other equalsness resolution.
 */
public class WrittenDateEqualsnessResolutionStrategy extends SimpleEqualsnessResolutionStrategy
{
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    public boolean resolveEqualsness(final Object first, final Object second)
    {
        if (first instanceof Date && second instanceof Date)
        {
            if (first == second)
                return true;
            if (first ==null || second ==null)
                return false;

            final Date firstDate = (Date) first;
            final Date secondDate = (Date) second;
            return DATE_FORMAT.format(firstDate).equals(DATE_FORMAT.format(secondDate));
        }
        else
            return super.resolveEqualsness(first, second);
    }
}
