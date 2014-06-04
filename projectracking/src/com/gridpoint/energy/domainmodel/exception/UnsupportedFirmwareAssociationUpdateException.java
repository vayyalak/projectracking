package com.gridpoint.energy.domainmodel.exception;

/**
 * Results from an attempt to update an endpoint firmware association synchronously, from its update method on the
 * endpoint service.
 *
 * Firmware updates are long-running and asynchronous. Consequently, they cannot be performed inline with an otherwise
 * synchronous endpoint update.
 */
public class UnsupportedFirmwareAssociationUpdateException extends Exception
{
    private long oldFirmwareId;
    private long newFirmwareId;
    private long endpointId;

    private static final long serialVersionUID = 6034860934869L;

    public UnsupportedFirmwareAssociationUpdateException(final long designatedEndpointId,
                                                         final long designatedOldFirmwareId,
                                                         final long designatedNewFirmwareId)
    {
        super("Can't update firmware of endpoint ID "+designatedEndpointId+" from "
                + designatedOldFirmwareId+ " to "+designatedNewFirmwareId+" here, synchronously. " +
                "Use /control/updateLiveFirmware, instead");

        endpointId = designatedEndpointId;
        oldFirmwareId = designatedOldFirmwareId;
        newFirmwareId = designatedNewFirmwareId;
    }

    public long getOldFirmwareId()
    {
        return oldFirmwareId;
    }

    public long getNewFirmwareId()
    {
        return newFirmwareId;
    }

    public long getEndpointId()
    {
        return endpointId;
    }
}
