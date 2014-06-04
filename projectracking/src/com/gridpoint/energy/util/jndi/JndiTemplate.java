package com.gridpoint.energy.util.jndi;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JndiTemplate
    extends org.springframework.jndi.JndiTemplate
    implements InitializingBean, DisposableBean
{
    private Map<String,Object> jndiObjects = new HashMap<String,Object>();

    public Map<String, Object> getJndiObjects ()
    {
        return jndiObjects;
    }

    public void setJndiObjects (final Map<String, Object> jndiObjects)
    {
        this.jndiObjects = jndiObjects;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        initJndi();
    }

    public void initJndi()
        throws NamingException
    {
        if( this.jndiObjects != null && !this.jndiObjects.isEmpty())
        {
            for (final Map.Entry<String, Object> jndiBinding : jndiObjects.entrySet())
            {
                rebind(jndiBinding.getKey(), jndiBinding.getValue());
            }
        }
    }

    @Override
    public void destroy()
        throws Exception
    {
        clearJndi();
    }

    public void clearJndi()
        throws NamingException
    {
        if(jndiObjects != null && !jndiObjects.isEmpty())
        {

            for (final String jndiName : jndiObjects.keySet())
            {
                unbind(jndiName);
            }
        }
    }
}
