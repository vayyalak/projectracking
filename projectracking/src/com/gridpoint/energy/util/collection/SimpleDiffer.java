package com.gridpoint.energy.util.collection;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Compares two parameters that are (or describe) JavaBeans of the same type.
 *
 * @author dhorlick
*/
public class SimpleDiffer
{
    private boolean descentLimited;
    private List<String> deepPropertyNamesNotToIgnore = new ArrayList<String>(Arrays.asList(new String[]{"id"}));
    private List<String> shallowPropertyNamesToIgnore = new ArrayList<String>();
    private EqualsnessResolutionStrategy equalsnessResolutionStrategy = new SimpleEqualsnessResolutionStrategy();

    public SimpleDiffer()
    {
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Delta> diffJavaBeans(final Object before, final Object after) throws IntrospectionException
    {
        return diff(before!=null?new JavaBeanToMapAdapter(before):null, after!=null?new JavaBeanToMapAdapter(after):null);
    }

    // We used to provide a method to diff JSON Objects, but the lack of a distinction between business objects (i.e.
    // JavaBeans) and Hash Maps introduced resolution ambiguities that proved too difficult to work around, especially
    // involving consistent iteration-order.

    /**
     * The before and after Maps must exhibit the same iteration order.
     *
     * @throws IllegalArgumentException if the provided maps are structurally inconsistent. This should never happen if they are
     * both generated from object of the same type.
     */
    public List<Delta> diff(final PropertyCatalogue before, final PropertyCatalogue after)
    {
        return diff(before, after, 0);
    }

    @SuppressWarnings("unchecked")
    public List<Delta> diff(final PropertyCatalogue before, final PropertyCatalogue after, final int depth)
    {
        if (before==null && after==null)
            return new ArrayList<Delta> ();
        else if (before==null)
            return allDeltas(after, true);
        else if (after==null)
            return allDeltas(before, false);

        final Iterator<? extends Map.Entry<String,?>> walkBefore = before.entrySet().iterator();
        final Iterator<? extends Map.Entry<String, ?>> walkAfter = after.entrySet().iterator();

        final List<Delta> deltas = new ArrayList<Delta> ();

        while (walkBefore.hasNext())
        {
            final Map.Entry<String, ?> entry1 = walkBefore.next();

            if (!walkAfter.hasNext())
            {
                throw new IllegalArgumentException("Different number of entries: "+entry1);
            }

            final Map.Entry<String, ?> entry2 = walkAfter.next();

            if (!entry1.getKey().equals(entry2.getKey()))
            {
                throw new IllegalArgumentException("Key mismatch: "+entry1.getKey()+"!="+entry2.getKey());
            }

            if (entry1.getValue() instanceof PropertyCatalogue && entry2.getValue() instanceof PropertyCatalogue)
            {
                final Iterator<Delta> subDeltaIter = diff((PropertyCatalogue) entry1.getValue(), (PropertyCatalogue) entry2.getValue(),
                        depth+1).iterator(); // unchecked assignment

                while (subDeltaIter.hasNext())
                {
                    final Delta subDelta = subDeltaIter.next();
                    deltas.add(new Delta (entry1.getKey()+"."+subDelta.getPropertyName(),
                            subDelta.getBefore(),
                            subDelta.getAfter()));
                }
            }
            else if (
                        (
                            (depth==0 && !shallowPropertyNamesToIgnore.contains(entry1.getKey()))
                            ||
                            (depth>0 && (!descentLimited || deepPropertyNamesNotToIgnore.contains(entry1.getKey())))
                        )
                        && !equalsnessResolutionStrategy.resolveEqualsness(entry1.getValue(), entry2.getValue())
                    )
            {
                deltas.add(new Delta (entry1.getKey(), entry1.getValue(), entry2.getValue()));
            }
        }

        return deltas;
    }

    /**
     * @return an unmodifiably-wrapped list.
     */
    public List<String> getDeepPropertyNamesNotToIgnore()
    {
        return Collections.unmodifiableList(deepPropertyNamesNotToIgnore);
    }

    /**
     * @throws IllegalStateException if descent has not been limited.
     */
    public void addDeepPropertyNameNotToIgnore(final String propertyName)
    {
        if (!descentLimited)
            throw new IllegalStateException("Wouldn't make sense to add a deep property name not to ignore, since descent has not been limited.");
        if (propertyName==null)
            throw new IllegalArgumentException("No property name provided.");

        deepPropertyNamesNotToIgnore.add(propertyName);
    }

    public int clearDeepPropertyNamesNotToIgnore()
    {
        final int doomed = deepPropertyNamesNotToIgnore.size();
        deepPropertyNamesNotToIgnore.clear();
        return doomed;
    }

    /**
     * @return if true, only look at deepPropertyNamesNotToIgnore when descending.
     */
    public boolean isDescentLimited()
    {
        return descentLimited;
    }

    public void setDescentLimited(final boolean designatedDescentLimited)
    {
        if (!designatedDescentLimited && deepPropertyNamesNotToIgnore.size()>0)
            throw new IllegalStateException("Can't unlimit descent since deep property names not to ignore have already been specified.");

        descentLimited = designatedDescentLimited;
    }

    public void setEqualsnessResolutionStrategy(final EqualsnessResolutionStrategy designatedEqualsnessResolutionStrategy)
    {
        equalsnessResolutionStrategy = designatedEqualsnessResolutionStrategy;
    }

    public List<Delta> allDeltas(final PropertyCatalogue map, final boolean adding)
    {
        return allDeltas(map, adding, 0);
    }

    public List<Delta> allDeltas(final PropertyCatalogue map, final boolean adding, final int depth)
    {
        final List<Delta> deltas = new ArrayList<Delta> ();

        for (final Map.Entry<String, ?> entry : map.entrySet())
        {
            final Delta delta = new Delta();
            delta.setPropertyName(entry.getKey());

            if (entry.getValue() instanceof PropertyCatalogue)
            {
                final Iterator<Delta> subDeltaIter = allDeltas((PropertyCatalogue)entry.getValue(), adding, depth+1).iterator(); // unchecked assignment

                while (subDeltaIter.hasNext())
                {
                    final Delta subDelta = subDeltaIter.next();
                    deltas.add(new Delta (entry.getKey()+"."+subDelta.getPropertyName(),
                            subDelta.getBefore(),
                            subDelta.getAfter()));
                }
            }
            else if
            (
                (!descentLimited || (depth==0 || deepPropertyNamesNotToIgnore.contains(entry.getKey())))
                 &&
                (depth>0 || !shallowPropertyNamesToIgnore.contains(entry.getKey()))
            )
            {
                if (adding)
                {
                    delta.setAfter(entry.getValue());
                }
                else
                {
                    delta.setBefore(entry.getValue());
                }

                deltas.add(delta);
            }
        }

        return deltas;
    }

    public List<String> getShallowPropertyNamesToIgnore()
    {
        return shallowPropertyNamesToIgnore;
    }

    public void setShallowPropertyNamesToIgnore(final List<String> designatedShallowPropertyNamesToIgnore)
    {
        shallowPropertyNamesToIgnore = designatedShallowPropertyNamesToIgnore;
    }

    public EqualsnessResolutionStrategy getEqualsnessResolutionStrategy()
    {
        return equalsnessResolutionStrategy;
    }

    public void addShallowPropertyNameToIgnore(final String propertyName)
    {
        shallowPropertyNamesToIgnore.add(propertyName);
    }

    public static interface EqualsnessResolutionStrategy
    {
        public boolean resolveEqualsness(Object a, Object b);
    }

}
