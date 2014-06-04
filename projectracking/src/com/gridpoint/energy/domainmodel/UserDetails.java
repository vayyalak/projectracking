package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * A domain object that represents a user record that comes back from the account service. This class is intentionally designed to track
 * Spring Security's UserDetails interface to allow for easy conversion to that implementation in the web tier
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The id */
    private Long id;

    /** The password. */
    private String password;

    /** The username. */
    private String username;

    /** A string representation of the user role */
    private String role;

    /** true if the account is not expired, false otherwise */
    private boolean accountNonExpired;

    /** true if the account is not locked out, false otherwise */
    private boolean accountNonLocked;

    /** true if the user must reset their password */
    private boolean resetPassword;

    /** true if the account is enabled, false otherwise */
    private boolean enabled;

    /** user authorities (such as tenants, paths allowed and capabilities) */
    private UserAuthorities authorities;

    private String language;

    private String measurementSystem;

    /** the email associated with the user **/
    private String email;

    /** the first name associated with the user **/
    private String firstName;

    /** the last name associated with the user **/
    private String lastName;

    /** the user default theme **/
    private String defaultTheme;

    /** The user default tenant **/
    private Long defaultTenant;

    private Date lastReadNewsFile;
    
    /**
     * Instantiates a new user details.
     * 
     * @param id
     *            the user primary key
     * @param username
     *            the username
     * @param password
     *            the password
     * @param enabled
     *            the enabled
     * @param accountNonExpired
     *            the account non expired
     * @param resetPassword
     *            whether the user needs to change password immediately upon login
     * @param accountNonLocked
     *            the account non locked
     * @param email
     *            the email of the account
     * @param role
     *            the role
     */
    public UserDetails(Long id, String username, String password, boolean enabled, boolean accountNonExpired, boolean resetPassword,
            boolean accountNonLocked, String role, UserAuthorities authorities, String email, String language, String measurementSystem,
            String firstName, String lastName, String defaultTheme, Long defaultTenant, Date lastReadNewsFile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.resetPassword = resetPassword;
        this.accountNonLocked = accountNonLocked;
        this.role = role;
        this.language = language;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
        this.measurementSystem = measurementSystem;
        this.defaultTheme = defaultTheme;
        this.defaultTenant = defaultTenant;
        this.lastReadNewsFile = lastReadNewsFile;
    }

    public UserDetails() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the role
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return the authorities
     */
    public UserAuthorities getAuthorities() {
        return authorities;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if is account non expired.
     * 
     * @return true, if is account non expired
     */
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * Checks if is account non locked.
     * 
     * @return true, if is account non locked
     */
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    /**
     * @return true, if the user must reset his password
     */
    public boolean isResetPassword() {
        return resetPassword;
    }

    /**
     * Checks if is enabled.
     * 
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @return the user default theme
     */
    public String getDefaultTheme() {
        return defaultTheme;
    }

    public void setDefaultTheme(final String designatedDefaultTheme) {
        defaultTheme = designatedDefaultTheme;
    }

    /**
     * @return the user default tenant id
     */
    public Long getDefaultTenant() {
        return defaultTenant;
    }

    public void setDefaultTenant(Long defaultTenant) {
        this.defaultTenant = defaultTenant;
    }    

    /**
     * returns the email for this user
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }

    public String getMeasurementSystem() {
        return measurementSystem;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "UserDetails [accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", resetPassword="
                + resetPassword + ", enabled=" + enabled + ", password=" + password + ", role=" + role + ", username=" + username + "]";
    }
    
// this is so that the spring layer can see the password
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(UserAuthorities authorities) {
        this.authorities = authorities;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setMeasurementSystem(String measurementSystem) {
        this.measurementSystem = measurementSystem;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setResetPassword(boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    public Date getLastReadNewsFile() {
        return lastReadNewsFile;
    }

    public void setLastReadNewsFile(Date lastReadNewsFile) {
        this.lastReadNewsFile = lastReadNewsFile;
    }
    
}
