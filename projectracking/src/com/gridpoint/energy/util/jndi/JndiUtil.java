package com.gridpoint.energy.util.jndi;
import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.HashMap;

/**
 *
 */
public class JndiUtil
{
    @Autowired
    private Context jndiContext;

    private Map<String,Object> map = new HashMap<String,Object>();

    public JndiUtil()
    {
        System.out.println("CONTEXT CTOR " + jndiContext  );
    }

    public Object addBinding( String name, Object obj )
        throws NamingException
    {
        System.out.println("Adding Binding " + name + " " + obj + " To " + jndiContext );
        //jndiContext.bind( name, obj );
        //return( obj );
        map.put( name, obj );
        return( obj );
    }

    public Map<String,Object> getMap()
    {
        return( map );
    }
}
