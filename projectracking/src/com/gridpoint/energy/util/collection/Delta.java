package com.gridpoint.energy.util.collection;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
* Represents a change in the value of a property.
*/
public class Delta
{
    private String propertyName;
    private Object before;
    private Object after;

    public Delta()
    {
    }

    public Delta(final String designatedPropertyName, final Object designatedBefore, final Object designatedAfter)
    {
        propertyName = designatedPropertyName;
        before = designatedBefore;
        after = designatedAfter;
    }

    public String getPropertyName()
    {
        return propertyName;
    }

    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }

    public Object getBefore()
    {
        return before;
    }

    public void setBefore(Object before)
    {
        this.before = before;
    }

    public Object getAfter()
    {
        return after;
    }

    public void setAfter(Object after)
    {
        this.after = after;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
