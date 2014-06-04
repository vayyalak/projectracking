package com.gridpoint.energy.util.osgi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * Because OSGI hides classes in different bundles, it becomes very difficult to deserialize objects.
 * This is because the Object you want may not be in your bundle / classpath... In this case we have serializationUtils
 * in the Utils Bundle, which will probably not contain the class you are trying to deserialize.
 * TO get around this you have to _HOPE_ that the OSGI container you are using is carefully managing the bundle context
 * and has assigned it to the current thread's contextclassloader.  If not.. you are out of luck.
 * http://forum.springsource.org/showthread.php?p=297391
 * As an alternative utils will have to dynamic import all, OR you have to put the boilerplate deserialization code
 * in every bundle that deserializes
 */
public class OsgiObjectInputStream extends ObjectInputStream
{
    //Flag that sets which scheme we try first... If true, then try the regular class loader first.
    //else try the TCCL first.
    private static boolean regularFirst = false;

    @SuppressWarnings ({"UnusedDeclaration"})
    public static void setRegularFirst (boolean regularFirst) {
        OsgiObjectInputStream.regularFirst = regularFirst;
    }

    public OsgiObjectInputStream (InputStream in)
            throws IOException {
        super(in);
    }

    @SuppressWarnings ({"UnusedDeclaration"})
    public OsgiObjectInputStream ()
            throws IOException, SecurityException
    {}

    @Override
    protected Class<?> resolveClass (ObjectStreamClass desc)
            throws IOException, ClassNotFoundException
    {
        ClassLoader currentTccl = Thread.currentThread().getContextClassLoader();

        if( regularFirst ) { //Try regular then try TCCL (Regular Optimized)
            try {
                return super.resolveClass(desc);
            }
            catch( Throwable ignored ) {}

            return currentTccl.loadClass(desc.getName());
        }
        else { //TRY the TCCL First then regular (OSGI optimized)
            try {
                return currentTccl.loadClass(desc.getName());
            }
            catch (Throwable ignored) {}

            return super.resolveClass(desc);
        }
    }
}
