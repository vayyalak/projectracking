package com.gridpoint.energy.domainmodel;


/**
 * Enumerates user roles used by the the GridPoint Unified Platform.
 */
// See roles.md for documentation
public final class UserRole {
    
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_PARTNER_ADMIN = "ROLE_PARTNER_ADMIN";
    public static final String ROLE_CUSTOMER_ADMIN = "ROLE_CUSTOMER_ADMIN";
    public static final String ROLE_COMMISSIONER = "ROLE_COMMISSIONER";
    public static final String ROLE_CI_ANALYST = "ROLE_CI_ANALYST";
    public static final String ROLE_CI_CUSTOMER_ANALYST = "ROLE_CI_CUSTOMER_ANALYST";
    public static final String ROLE_CI_SITE_MANAGER = "ROLE_CI_SITE_MANAGER";
    public static final String ROLE_EVSE_ANALYST = "ROLE_EVSE_ANALYST";
    public static final String ROLE_PROVISIONER = "ROLE_PROVISIONER";

    /**
     * Gets whether or not the role is a superuser-administrator.
     * @param roleName the name of the user role
     * @return true if the role corresponds to a superuser-administrator; otherwise, false.
     */
    public static boolean isSuperAdmin(String roleName) {
        return ROLE_ADMIN.equals(roleName);
    }

    /**
     * Gets whether a role can administer end users, including assigning roles and resetting passwords.
     * @param roleName the name of the user role
     * @return true if the role is administrative; otherwise, false.
     */
    public static boolean isEnduserAdmin(String roleName) {
    	return
                ROLE_ADMIN.equals(roleName) ||
                ROLE_PARTNER_ADMIN.equals(roleName) ||
                ROLE_CUSTOMER_ADMIN.equals(roleName);
    }
}
