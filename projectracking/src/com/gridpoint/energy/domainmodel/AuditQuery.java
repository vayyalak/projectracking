package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class AuditQuery implements Serializable
{
    private static final long serialVersionUID = -40597811324444840L;

    private String domainTypeSimpleName;
    private Long entityId;
    private Ordering ordering;

    /**
     * "Premises", "Enduser", "Device", "Tenant", "Firmware", or "Endpoint". Case-insensitive.
     */
    public String getDomainTypeSimpleName()
    {
        return domainTypeSimpleName;
    }

    public void setDomainTypeSimpleName(final String domainTypeSimpleName)
    {
        this.domainTypeSimpleName = domainTypeSimpleName;
    }

    public Long getEntityId()
    {
        return entityId;
    }

    public void setEntityId(final Long entityId)
    {
        this.entityId = entityId;
    }

    public Ordering getOrdering()
    {
        return ordering;
    }

    public void setOrdering(final Ordering designatedOrdering)
    {
        ordering = designatedOrdering;
    }

    public void setOrdering(final String orderBy)
    {
        ordering = new Ordering(orderBy);
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
