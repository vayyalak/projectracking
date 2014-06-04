package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.Query;
import java.io.Serializable;

/**
 * Models a results page defined by a start index and a number of records.
 *
 * This is useful for creating odata-like services.
 */
public class Page implements Serializable
{
    private static final long serialVersionUID = -5051330718402361183L;

    private Integer indexOfFirstRecord;
    private Integer numberOfRecords;

    public Page()
    {
    }

    public Page(final Integer designatedIndexOfFirstRecord, final Integer designatedNumberOfRecords)
    {
        setIndexOfFirstRecord(designatedIndexOfFirstRecord);
        setNumberOfRecords(designatedNumberOfRecords);
    }

    /**
     * @return The index of the first record to retrieve, counting up from zero.
     *
     * In odata, this is called "skip".
     */
    public Integer getIndexOfFirstRecord()
    {
        return indexOfFirstRecord;
    }

    public void setIndexOfFirstRecord(final Integer designatedSkip)
    {
        if (designatedSkip!=null && designatedSkip<0)
        {
            throw new IllegalArgumentException("Cannot be negative: "+designatedSkip);
        }

        indexOfFirstRecord = designatedSkip;
    }

    /**
     * @return The number of records to retrieve.
     *
     * In odata, this is misleadingly called "top".
     */
    public Integer getNumberOfRecords()
    {
        return numberOfRecords;
    }

    public void setNumberOfRecords(final Integer designatedNumberOfRecords)
    {
        if (designatedNumberOfRecords!=null && designatedNumberOfRecords<0)
        {
            throw new IllegalArgumentException("Cannot be negative: "+designatedNumberOfRecords);
        }

        numberOfRecords = designatedNumberOfRecords;
    }

    /**
     * Applies the parameters associated with this page to a JPA query.
     */
    public void applyTo(final Query query)
    {
        if (getIndexOfFirstRecord()!=null)
        {
            query.setFirstResult(getIndexOfFirstRecord());
        }
        if (getNumberOfRecords()!=null)
        {
            query.setMaxResults(getNumberOfRecords());
        }
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
