package com.gridpoint.energy.util.jndi;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.RefAddr;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Enumeration;

/**
 * Simple JNDI factory for returning Properties object.
 *
 * The key/value pairs that will be returned in the Properties
 * object come from a javax.naming.Reference object that is
 * setup by the container.
 */
public class JndiPropertyFactory implements ObjectFactory {

    public Object getObjectInstance( Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment )
            throws Exception {
        if (obj instanceof Reference) {
            Reference reference = (Reference)obj;
            Enumeration<RefAddr> attributes = reference.getAll();
            Properties props = new Properties();

            while ( attributes.hasMoreElements() ) {
                RefAddr refAddr = attributes.nextElement();
                props.put( refAddr.getType(), refAddr.getContent() );
            }
            return props;
        }

        return null;
    }

}
