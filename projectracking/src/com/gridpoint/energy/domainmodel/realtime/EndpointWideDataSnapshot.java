package com.gridpoint.energy.domainmodel.realtime;

import com.gridpoint.energy.domainmodel.Device;
import com.gridpoint.energy.util.tree.AbstractDomainIndexTreeNode;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * A snapshot of all available real time data for an endpoint.
 *
 * @author dhorlick
*/
public class EndpointWideDataSnapshot extends AbstractDomainIndexTreeNode<String, DeviceWideDataSnapshot>
{
    private long gpupEndpointId;

    public long getGpupEndpointId()
    {
        return gpupEndpointId;
    }

    public void setGpupEndpointId(final long gpupEndpointId)
    {
        this.gpupEndpointId = gpupEndpointId;
    }

    public Long key()
    {
        return gpupEndpointId;
    }

    public DeviceWideDataSnapshot newElementInstance(final String deviceAddress)
    {
        final DeviceWideDataSnapshot deviceWideDataSnapshot = new DeviceWideDataSnapshot();
        if (deviceWideDataSnapshot.getDevice()==null)
            deviceWideDataSnapshot.setDevice(new Device());
        deviceWideDataSnapshot.getDevice().setAddress(deviceAddress);
        deviceWideDataSnapshot.getDevice().setEndpointId(gpupEndpointId);
        return deviceWideDataSnapshot;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
