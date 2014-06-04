package com.gridpoint.energy.util.jndi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Jndi Context based on a Spring application context..
 * Very similar to org.apache.xbean.spring.jndi.SpringInitialContextFactory, but this one honors PropertyConfigurer's
 */
public class SpringInitialContextFactory implements InitialContextFactory {
    private static final transient Log log = LogFactory.getLog(SpringInitialContextFactory.class);

    private static final Map cache = new HashMap();

    private static Context singleton;

    /**
     * A factory method which can be used to initialise a singleton JNDI context from inside a Spring.xml
     * such that future calls to new InitialContext() will reuse it
     */
    public static Context makeInitialContext()
    {
        singleton = new DefaultContext();
        return singleton;
    }

    public Context getInitialContext(Hashtable environment) throws NamingException {
        if (singleton != null) {
            return singleton;
        }

        Context answer = null;
        Object value = environment.get(Context.PROVIDER_URL);

        //If file path go through file system first
        if(value != null && value instanceof String){

            answer = getFilePath((String) value);
            if(answer == null){
                log.warn("Found parameter with but could not load off of a file resource: " + value);
            }

        }
        if(value != null &&  answer == null){
            //try off classpath, but catch exceptions for non fatal
            answer = getClassPath((String) value);
        }
        //use classpath
        if (answer == null){
            answer = getClassPath("jndi.xml");
        }
        if (answer == null){
            answer = getDefaultContext(environment);
        }

        return answer;
    }

    private Context getClassPath(String key){
        Context answer = null;
        ResourceEditor editor = new ResourceEditor();
        editor.setAsText(key);
        BeanFactory myBeans = loadContext((Resource) editor.getValue(),key);
        if(myBeans != null){
            answer = (Context) myBeans.getBean("jndi");
        }
        return answer;
    }
    private Context getFilePath(String key){
        Context answer = null;
        try{
            answer = (Context) createContext(key).getBean("jndi");
        } catch (Exception e){
            log.warn("Spring JNDI failed to load file: " + key, e);
        }
        return answer;
    }

    private Context getDefaultContext(Hashtable environment){
        log.warn("Couldn't find the file by any means nessesary loading default");
        return new DefaultContext(environment, new ConcurrentHashMap());
    }

    @SuppressWarnings ({"unchecked"})
    protected BeanFactory loadContext(Resource resource, String key) {
        synchronized (cache) {
            BeanFactory answer = (BeanFactory) cache.get(key);
            if (answer == null) {
                answer =  createContext(resource);
                cache.put(key, answer);
            }
            return answer;
        }
    }

    @SuppressWarnings ({"unchecked"})
    protected BeanFactory loadContext(String key) throws IOException {
        synchronized (cache) {
            BeanFactory answer = (BeanFactory) cache.get(key);
            if (answer == null) {
                answer =  createContext(key);
                cache.put(key, answer);
            }
            return answer;
        }
    }

    protected BeanFactory createContext(Resource resource)  {
        if ( !resource.exists() ) {
            log.info("Could not load JNDI context.  Resource does not exist: " + resource.getFilename() );
            return null;
        }
        log.info("Loading.. JNDI context from: " + resource.getFilename() );
        return new ClassPathXmlApplicationContext(resource.getFilename());
    }
    protected BeanFactory createContext(String location) throws IOException {
        log.info("Loading.. JNDI context from: " + location );
        return new FileSystemXmlApplicationContext(location);
    }

}
