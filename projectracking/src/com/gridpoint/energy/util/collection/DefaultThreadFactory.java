package com.gridpoint.energy.util.collection;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class DefaultThreadFactory
        implements java.util.concurrent.ThreadFactory
{
        private static  final    AtomicInteger   poolNumber      = new AtomicInteger(1);

        private final    ThreadGroup     group;
        private final    AtomicInteger   threadNumber    = new AtomicInteger(1);
        private final    String          namePrefix;
        //user configurable thread name prefix
        private final	 String			 userThreadNamingPrefix;
        
        public DefaultThreadFactory ()
        {
        	this(null);
        }

        public DefaultThreadFactory (String userThreadName)
        {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() :
                                 Thread.currentThread().getThreadGroup();
            
            if (userThreadName != null) {
            	userThreadNamingPrefix = userThreadName;
            } else {
            	userThreadNamingPrefix = null;
            }
            
            if (userThreadNamingPrefix != null) {
            	namePrefix = userThreadNamingPrefix + "_" + "pool-" + poolNumber.getAndIncrement() + "-thread-";
            } else {
            	namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
               "-thread-";
            }
        }

        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(group,
                                  r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            if (!t.isDaemon())
                t.setDaemon(true);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
