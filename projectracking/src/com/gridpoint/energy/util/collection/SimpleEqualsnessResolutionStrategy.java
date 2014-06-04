package com.gridpoint.energy.util.collection;

/**
 * Resolves the equalsness of objects using {@link Object#equals}.
 *
 * @author dhorlick
 */
public class SimpleEqualsnessResolutionStrategy implements SimpleDiffer.EqualsnessResolutionStrategy
{
    public boolean resolveEqualsness(final Object first, final Object second)
    {
        if (first == second)
            return true;
        if (first == null || second ==null)
            return false;

        return first.equals(second);
    }
}
