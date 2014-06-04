package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A list of references that can be used to target remote requests against controllers. Seeks to encapsulate
 * architecture-specific (i.e. GPEC vs. ADM) concerns.
 *
 * GPEC controllers are identified by their GPUP endpoint ID.
 *
 * ADM services identify endpoints by a string "site ID" associated with the controller, and the corresponding GPUP
 * endpoint and premises ID's.
 *
 * This catalog will not include "virtual" endpoints like Weather, or side-lined hardware platforms like EVSE.
 *
 * @author dhorlick
 */
public class ControllerCatalog
{
    private Set<AdmControllerIdentity> admControllerIdentities = new LinkedHashSet<AdmControllerIdentity> ();
    private Set<Long> gpecEndpointIds = new LinkedHashSet<Long> ();

    public Set<AdmControllerIdentity> getAdmControllerIdentities()
    {
        return admControllerIdentities;
    }

    public void setAdmControllerIdentities(final Set<AdmControllerIdentity> designatedAdmControllerIdentities)
    {
        admControllerIdentities = designatedAdmControllerIdentities;
    }

    public Set<Long> getGpecEndpointIds()
    {
        return gpecEndpointIds;
    }

    public void setGpecEndpointIds(final Set<Long> gpecEndpointIds)
    {
        this.gpecEndpointIds = gpecEndpointIds;
    }

    public Set<String> admSiteIds()
    {
        final Set<String> admSiteIds = new LinkedHashSet<String> ();
        for (final AdmControllerIdentity admControllerIdentity : admControllerIdentities)
        {
            admSiteIds.add(admControllerIdentity.getAdmSiteId());
        }

        return admSiteIds;
    }

    public Set<Long> admControllerGpupEndpointIds()
    {
        final Set<Long> endpointIds = new LinkedHashSet<Long> ();
        for (final AdmControllerIdentity admControllerIdentity : admControllerIdentities)
        {
            endpointIds.add(admControllerIdentity.getEndpointId());
        }

        return endpointIds;
    }

    /**
     * @return The GPUP Premises ID for each ADM controller.
     */
    public Set<Long> admControllerGpupPremisesIds()
    {
        final Set<Long> endpointIds = new LinkedHashSet<Long> ();
        for (final AdmControllerIdentity admControllerIdentity : admControllerIdentities)
        {
            endpointIds.add(admControllerIdentity.getPremisesId());
        }

        return endpointIds;
    }

    /**
     * @return The identities of all controller endpoints in GPUP, whether they be ADM or GPEC.
     */
    public Set<Long> allGpupEndpointIds()
    {
        final SortedSet<Long> result = new TreeSet<Long> ();

        result.addAll(admControllerGpupEndpointIds());
        result.addAll(getGpecEndpointIds());

        return result;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
