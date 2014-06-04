package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *  Identifies an ADM site in ADM or GPUP. Useful for targeting batch operations.
 *
 *  @author dhorlick
 */
public class AdmControllerIdentity
{
    private long endpointId;
    private long premisesId;
    private String admSiteId;

    public AdmControllerIdentity(final long designatedEndpointId, final long designatedPremisesId,
                                 final String designatedAdmSiteId)
    {
        endpointId = designatedEndpointId;
        premisesId = designatedPremisesId;
        admSiteId = designatedAdmSiteId;
    }

    public long getEndpointId()
    {
        return endpointId;
    }

    public String getAdmSiteId()
    {
        return admSiteId;
    }

    public long getPremisesId()
    {
        return premisesId;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(891245, 3985323, this);
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object other)
    {
        return EqualsBuilder.reflectionEquals(this, other);
    }
}
