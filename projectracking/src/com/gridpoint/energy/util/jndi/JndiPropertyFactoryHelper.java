package com.gridpoint.energy.util.jndi;

import javax.naming.Reference;
import javax.naming.StringRefAddr;
import java.util.Properties;
import java.util.Map;

/**
 * Simple helper class to encapsulate creation of a javax.naming.Reference
 * to a JndiPropertyFactory that can be used inside of jndi.xml.
 *
 * Reference can be setup in jndi.xml entries map as follows:
 * <pre>
 * &lt;bean id="jndi"
 *       class="com.gridpoint.energy.util.jndi.SpringInitialContextFactory"
 *       factory-method="makeInitialContext"&gt;
 *     &lt;property name="entries"&gt;
 *         &lt;util:map&gt;
 *             &lt;!-- JNDI lookup name --&gt;
 *             &lt;entry key="gpup_properties"&gt;
 *                 &lt;bean class="com.gridpoint.energy.util.jndi.JndiPropertyFactoryHelper"
 *                         factory-method="makeJndiPropertyFactory"&gt;
 *                     &lt;!-- Properties list --&gt;
 *                     &lt;constructor-arg type="java.util.Properties"&gt;
 *                         &lt;value&gt;
 *                             testProperty1=value1
 *                             testProperty2=value2
 *                         &lt;/value&gt;
 *                     &lt;/constructor-arg&gt;
 *                 &lt;/bean&gt;
 *             &lt;/entry&gt;
 *         &lt;/util:map&gt;
 *     &lt;/property&gt;
 * &lt;/bean&gt;
 * </pre>
 *
 */
public class JndiPropertyFactoryHelper {
    public static Reference makeJndiPropertyFactory( Properties props ) {
        // Create a new reference to a JndiPropertyFactory that will return
        // an instance of java.util.Properties.
        Reference ref = new Reference( Properties.class.getName(),
                                       JndiPropertyFactory.class.getName(),
                                       null );

        // Iterate through all entries in the properties set and add to
        // reference.
        for ( Map.Entry entry : props.entrySet() ) {
            if ( entry.getKey() instanceof String && entry.getValue() instanceof String ) {
                ref.add( new StringRefAddr( (String)entry.getKey(), (String)entry.getValue() ) );
            }
        }

        return ref;
    }
}
