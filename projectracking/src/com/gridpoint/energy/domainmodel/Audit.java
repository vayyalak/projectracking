package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.Delta;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The outbound companion to {@link com.gridpoint.energy.domainmodel.Event}.
 */
public class Audit implements Serializable
{
    private static final long serialVersionUID = 1078L;

    private Long auditId;
    private UserDetails actor;
    private CrudOperation operation;
    private Long targetEntityId;
    private Date creationDate;
    private List<Delta> propertyDeltas = new ArrayList<Delta>();
    private String targetDomainObjectName;

    public Long getAuditId()
    {
        return auditId;
    }

    public void setAuditId(Long auditId)
    {
        this.auditId = auditId;
    }

    public UserDetails getActor()
    {
        return actor;
    }

    public void setActor(final UserDetails actor)
    {
        this.actor = actor;
    }

    public CrudOperation getOperation()
    {
        return operation;
    }

    public void setOperation(final CrudOperation operation)
    {
        this.operation = operation;
    }

    public Long getTargetEntityId()
    {
        return targetEntityId;
    }

    public void setTargetEntityId(final Long targetEntityId)
    {
        this.targetEntityId = targetEntityId;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getTargetDomainObjectName()
    {
        return targetDomainObjectName;
    }

    public void setTargetDomainObjectName(final String targetDomainObjectName)
    {
        this.targetDomainObjectName = targetDomainObjectName;
    }

    public void setPropertyDeltas(final List<Delta> designatedPropertyDeltas)
    {
        propertyDeltas = designatedPropertyDeltas;
    }

    public List<Delta> getPropertyDeltas()
    {
        return propertyDeltas;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
