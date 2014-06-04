package com.gridpoint.energy.util.jndi;

import org.apache.xbean.spring.jndi.SpringInitialContextFactory;

import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

/**
 *
 */
public class JndiContextFactory
    extends SpringInitialContextFactory
{
    public JndiContextFactory ( final List<Map<String,Object>> entries )
        throws NamingException
    {
        Context context = org.apache.xbean.spring.jndi.SpringInitialContextFactory.makeInitialContext();
        bind( context, entries );
    }

    private void bind( Context context, List<Map<String,Object>> entries )
        throws NamingException
    {
        Map<String,Object> combined = new HashMap<String,Object>();

        for( Map<String,Object> entryMap : entries )
        {
            combined.putAll( entryMap );
        }

        for (final Map.Entry<String, Object> jndiBinding : combined.entrySet() )
        {
            context.rebind(jndiBinding.getKey(), jndiBinding.getValue());
        }
    }
}
