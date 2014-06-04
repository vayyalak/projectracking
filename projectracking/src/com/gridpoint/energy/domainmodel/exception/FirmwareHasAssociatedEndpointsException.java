package com.gridpoint.energy.domainmodel.exception;

import com.gridpoint.energy.domainmodel.Endpoint;

import java.util.Collections;
import java.util.Set;

/**
 * @author dhorlick
 */
public class FirmwareHasAssociatedEndpointsException extends Exception
{
    private static final long serialVersionUID = 294023963496L;

    private Set<Endpoint> associatedEndpoints;

    public FirmwareHasAssociatedEndpointsException(final Set<Endpoint> designatedAssociatedEndpoints)
    {
        associatedEndpoints = designatedAssociatedEndpoints;
    }

    public Set<Endpoint> getAssociatedEndpoints()
    {
        return Collections.unmodifiableSet(associatedEndpoints);
    }
}
