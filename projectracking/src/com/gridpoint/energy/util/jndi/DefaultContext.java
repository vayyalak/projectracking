package com.gridpoint.energy.util.jndi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.NamingException;
import java.util.*;

/**
 *
 */
@SuppressWarnings ({"unchecked"})
public class DefaultContext
    extends org.apache.xbean.spring.jndi.DefaultContext
{
    private static final transient Log logger = LogFactory.getLog(DefaultContext.class);
    private static final long serialVersionUID = -5754338187296859149L;

    public DefaultContext() {
        super();
    }

    public DefaultContext(Hashtable env) {
        super(env);
    }

    public DefaultContext(Hashtable environment, Map bindings) {
        super( environment, bindings );
    }

    public DefaultContext(Hashtable environment, Map bindings, String nameInNamespace) {
        super( environment, bindings, nameInNamespace );
    }

    public void setEntriesList( final List<Map<String,Object>> entries)
            throws NamingException
    {
        Map<String,Object> unionedCollection = new HashMap<String,Object>();


        if (entries != null) {
            logger.debug("setEntriesList Start: " + entries.size()  );
            for( Map<String,Object> subMap : entries)
            {
                if( subMap != null ) {
                    if( logger.isDebugEnabled() )
                    {
                        for(Map.Entry entry : subMap.entrySet() )
                        {
                            if( entry != null ) {
                                logger.debug("setEntriesList. Key:" + entry.getKey() + " Value:" + entry.getValue() );
                            }
                        }
                    }
                    unionedCollection.putAll( subMap );
                }
            }
        }
        else
        {
            logger.debug("setEntriesList Start: Null Entries."   );
        }
        setEntries( unionedCollection );
    }


}
