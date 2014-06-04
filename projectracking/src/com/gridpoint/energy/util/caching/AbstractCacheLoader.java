package com.gridpoint.energy.util.caching;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public abstract class AbstractCacheLoader<T> implements Runnable, ApplicationContextAware {

	private static final Logger log = Logger.getLogger(AbstractCacheLoader.class);

    // DOES NOT WORK IN UNIT TEST WITH @Autowired, don't know why.
    protected T cache;

    /** Thread which will populate the cache. */
    private volatile Thread thread;

    /** The amount of time the last caching run too. */
    private long elapsed = -1;

    /** The time of the last caching run. */
    private long time = -1;

    protected long runDelay = 60000L;

    /** Is the component active? individual instance, not clustered */
    private volatile boolean active = false;

    @ManagedAttribute
    public boolean getActive() {
        return this.active;
    }

    @ManagedAttribute
    public synchronized void setActive(boolean active) {
        if (this.active != active) {
            this.active = active;
            if (active) {
                notifyAll();
            } else if (thread != null) {
                thread.interrupt();
            }
        }
    }

    /**
     * Adjusts the amount of sleep in between
     * @param delay
     */
    @ManagedOperation
    public void setRunDelay(long delay) {
        this.runDelay = delay;
    }

    /**
     * T
     * @return
     */
    @ManagedOperation
    public long getRunDelayMillis() {
        return this.runDelay;
    }

    /**
     * Since we are calling T.process(),
     * if we want to use a transaction on our bean we need to make sure we wire in the spring version of our delegate.
     * If we use proxies, we will need to be able to resolve the correct bean by name, instead of types.
     */
    private String cacheServiceBeanName;

    private static ApplicationContext appContext = null;

    public T getCache() {
        return this.cache;
    }

    public void setCache(T cache) {
        this.cache = cache;
    }

    @ManagedAttribute
    public long getElapsed() {
        return this.elapsed;
    }

    @ManagedAttribute
    public Date getTime() {
        return new Date(this.time);
    }

    @SuppressWarnings("unused")
	@ManagedOperation
    private final synchronized void start() {
        if (log.isInfoEnabled()) {
            log.info("starting");
        }

        if (appContext == null) {
        	throw new RuntimeException("Can't wire transactional caching service because the application context is unavailable");
        }

        if (thread == null) {
            thread = new Thread(this, this.getClass().getName().replaceAll("com\\.gridpoint\\.energy\\.",""));
            thread.setDaemon(true);
            thread.start();
        }
    }

    @SuppressWarnings("unused")
	@ManagedOperation
    private final synchronized void stop() {
        if (log.isInfoEnabled()) {
            log.info("stopping");
        }

        if (thread != null) {
            Thread reaper = thread;
            thread = null;
            reaper.interrupt();
        }
    }

    /**
     * Try to make another abstract version of process() get invoked, based on the subclass that this
     * class actually is. look at this class run method for more details.
     */
    @ManagedOperation
    public void forceRefreshIfIdle() {
        if(thread != null) {
            thread.interrupt();
        }
    }


    @SuppressWarnings("unchecked")
	@Override
    public void run() {
    	//race condition, alot of times the cacheservicebeanname is used to get a reference to 'this' from the spring context
    	//the problem is 'this' is only added to the spring context once the init method returns
    	//sometimes this thread will start up faster than the bean is added to spring and we will not find it on our first call
    	//to the app context
    	//i really dont feel like this is an ideal solution, we need something better but i really dont have time for it right now.
    	//try a couple of times to get the bean
    	//in order for transactions to work on our cache service beans, we need to get the spring proxy reference
    	//TODO: http://jira.gridpoint.com/browse/GPUP-4385

    	int MAX_TRIES = 5;
    	int DELAY = 1000;

    	int currentTries = 0;
    	AbstractCacheLoader<T> me = null;

    	while (currentTries < MAX_TRIES) {
    		try {
    			me = (AbstractCacheLoader<T>)appContext.getBean(cacheServiceBeanName, this.getClass());
    		} catch (Throwable e) {
    			log.warn(e.getMessage());
    		}
    		currentTries++;

    		if (me != null) {
    			break;
    		}

    		try {
				Thread.sleep(DELAY);
			} catch (InterruptedException ignored) {}
    	}

    	if (me == null) {
    		throw new RuntimeException("Can't load cache bean ["+cacheServiceBeanName+"]");
    	}


    	//run the processing loop
        while(thread == Thread.currentThread()) {
            synchronized(this) {
                while (!active) {
                    log.debug("waiting to become active");
                    try {
                        wait();
                        log.debug("possibly starting: " + active);
                    } catch (InterruptedException ex) {
                        // ignore.
                    }
                }
            }

            try {
            log.debug("populating sessions cache");

            if (me != null) {
	            time = System.currentTimeMillis();
	            me.process();
	            elapsed = (System.currentTimeMillis() - time);
            }

                Thread.sleep(runDelay);
            } catch (InterruptedException ex) {
                log.warn(ex);
            }
        }

    }

    public abstract void process();

    @Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		AbstractCacheLoader.appContext = context;
	}

	public void setCacheServiceBeanName(String cacheBeanName) {
		this.cacheServiceBeanName = cacheBeanName;
	}

	public String getCacheServiceBeanName() {
		return cacheServiceBeanName;
	}
}
