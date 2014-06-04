package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.text.HiddenString;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * An abbreviated form of the information kept in {@link UserDetails} that is more convenient for self-service edits
 * to user account information by the actual account holder.
 *
 * This is currently used only for auditing purposes.
 */
public class UserSettings implements Serializable
{
    private static final long serialVersionUID = 11241255L;

    private Long id;

    /** the email associated with the user **/
    private String email;

    private HiddenString password;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public HiddenString getPassword()
    {
        return password;
    }

    public void setPassword(final HiddenString password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
