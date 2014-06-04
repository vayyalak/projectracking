package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a windowed view of a large List, for paging-thru.
 *
 * (Pattern ripped-off from odata)
 */
public class Excerpt<T extends Serializable> implements Serializable
{
    private static final long serialVersionUID = -5528301346998900561L;

    private List<T> list;
    private Integer totalCount;

    public List<T> getList()
    {
        return list;
    }

    public void setList(final List<T> designatedList)
    {
        if (designatedList!=null && totalCount!=null && designatedList.size()>totalCount)
        {
            throw new IllegalArgumentException("Proposed list size would exceed total count: "+totalCount);
        }

        list = designatedList;
    }

    public Integer getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(final Integer designatedTotalCount)
    {
        if (designatedTotalCount!=null && list!=null && designatedTotalCount<list.size())
        {
            throw new IllegalArgumentException("List size: "+list.size()+" would exceed proposed total count: " + designatedTotalCount);
        }

        totalCount = designatedTotalCount;
    }

    @Override
    public String toString()
    {
        return new ReflectionToStringBuilder(this).toString();
    }
}
