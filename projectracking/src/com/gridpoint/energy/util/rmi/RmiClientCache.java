package com.gridpoint.energy.util.rmi;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class RmiClientCache
{
    private ConcurrentHashMap<String,Object> rmiRefMap        = new ConcurrentHashMap<String, Object>();
    private ConcurrentHashMap<Object,String> reverseRmiRefMap = new ConcurrentHashMap<Object, String>();

    public Object getRmiRef( String rmiRef, Class clazz )
    {
        Object result = rmiRefMap.get( rmiRef );
        if( result != null )
        {
            return( result );
        }
        else
        {
            //Multi Create races are ok... 
            RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
            proxy.setServiceUrl( rmiRef );
            proxy.setServiceInterface( clazz );
            proxy.afterPropertiesSet();
            result = proxy.getObject();

            rmiRefMap.put( rmiRef, result );

            return( result );
        }
    }

    public void invalidateRef( final Object ref )
    {
        String rmiVal = reverseRmiRefMap.remove( ref );
        if( rmiVal != null )
        {
            rmiRefMap.remove( rmiVal, ref );
        }
    }


}
