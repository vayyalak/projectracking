package com.gridpoint.energy.domainmodel;

/**
 *
 */
public class ReferenceTokens
{
    public static final String ADM_TOKEN = "ADM_TOKEN:";

    public static String premisesReferenceId(String admShortEntityName) {
        return ADM_TOKEN + admShortEntityName;
    }

    public static String premisesTagReferenceId(long admSiteEntityId) {
        return ADM_TOKEN + admSiteEntityId;
    }

    public static String endpointReferenceId(long admDeviceNumber, String admShortEntityName) {
        return ADM_TOKEN + admDeviceNumber + ":" + admShortEntityName;
    }

    public static String endpointReferenceId(String specialDeviceName, String admShortEntityName) {
        return ADM_TOKEN + specialDeviceName + ":" + admShortEntityName;
    }

    public static String channelReferenceId(long admChannelId) {
        return ADM_TOKEN + admChannelId;
    }

    /**
     * @deprecated DWC: please use isAdmReferenceId instead
     * @param referenceId
     */
    public static boolean isReferenceId(String referenceId) {
        return isAdmReferenceId(referenceId);
    }

    public static boolean isAdmReferenceId(String referenceId){
        return referenceId.startsWith(ADM_TOKEN);
    }

    public static String extractReference(String referenceId) {
        int last = referenceId.lastIndexOf(':');
        if (last < 0) {
            last = 0;
        } else {
            last++;
        }
        
        return referenceId.substring(last);
    }
  
}
