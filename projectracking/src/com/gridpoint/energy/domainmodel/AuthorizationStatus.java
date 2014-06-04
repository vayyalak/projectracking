package com.gridpoint.energy.domainmodel;

/**
 * Indicates whether or not a user operation is allowed.
 */
public enum AuthorizationStatus {
    // DEVELOPERS: order matters, as the index of the enum needs to correspond to
    // com.gridpoint.energy.endpointadapters.geepadapter.model.GeepAuthorizationStatus.

    /**
     * Indicates that the user operation is explicitly allowed.
     */
    DENY,

    /**
     * Indicates that the user operation is explicitly NOT allowed.
     */
    ALLOW;

    /**
     * Gets the authorization status corresponding to an integer
     * @param i the integer to convert to an authorizations status
     * @return the authorization status corresponding to {@code i}, or null if there is no corresponding status.
     */
    public static AuthorizationStatus fromInteger(Integer i) {
        if (i == null) {
            return null;
        }

        try {
            return values()[i];
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public int toInt() {
        return ordinal();
    }
}
