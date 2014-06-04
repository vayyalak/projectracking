package com.gridpoint.energy.util.logging;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LogThrottle {
    private final int logMod;
    private final Map<Long,Integer> logThrottle  = new HashMap<Long, Integer>();

    public LogThrottle (int logMod) {
        this.logMod = logMod;
    }

    /**
     * Return true if we should not log the message.
     * @param logId
     * @return
     */
    public boolean logThrottle (long logId) {
        Integer val = logThrottle.get(logId);
        if( val == null  ) {
            val = 0;
        }
        logThrottle.put(logId,val+1);
        if( val % logMod != 0 ) {
            return( true );
        }else {
            return( false );
        }
    }

}
