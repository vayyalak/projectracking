package com.gridpoint.energy.domainmodel;

/**
 * Defines the type of policies that the database supports for authentication mechanisms
 * 
 */
public enum AuthenticationPolicyType {
    /**
     * always allow the request
     */
    ALWAYS_ALLOW,

    /**
     * always deny the request
     */
    ALWAYS_DENY,

    /**
     * perform a lookup. if that throws an exception or fails, fall back to ALWAYS_ALLOW
     */
    LOOKUP_FALLBACK_ALLOW,

    /**
     * perform a lookup. if that throws an exception or fails, fall back to ALWAYS_DENY
     */
    LOOKUP_FALLBACK_DENY
}
